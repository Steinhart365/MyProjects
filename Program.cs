//Steinhart
using System;
using System.Collections.Generic;
using Microsoft.VisualBasic.CompilerServices;

namespace HelloGithubClassroom
{
    class Fraction
    {
        static void Main(string[] args)
        {
        }

        //constructor with default values
        public Fraction(int num = 0, int den = 1)
        {
            if (den == 0)
            {
                throw ArgumentOutOfRangeException("Cannot use zero in denominator.");
            }
            // because the variables are read-only it is very difficult to call an outside method to simplify.
            //without causing infinite recursive calls. Therefore I built the simplification right into the constructor

            if (num == den)
            {
                Numerator = 1;
                Denominator = 1;
            }
            else if (num == 0)
            {
                Numerator = 0;
                Denominator = 1;
            }
            else
            {
                int gcd = FindGcd(den, num);
                //once we have the GCF, divide both Num and Den by that to find simplest form
                Numerator = num / gcd;
                Denominator = den / gcd;
            }
        }

        // Making the class immutable with read-only properties.       
        public int Numerator { get; }
        public int Denominator { get; }

        static int FindGcd(int a, int b)
        {
            //Thanks to Euclid finding GCD shouldn't take too long
            if (a == 0 || b == 0)
            {
                return 0;
            }
            else
            {
                while (a != b)
                    if (a < b)
                    {
                        b -= a;
                    }
                    else
                    {
                        a -= b;
                    }

                return (a);
            }
        }

        private static Exception ArgumentOutOfRangeException(string v)
        {
            throw new NotImplementedException();
        }

        // a method to convert a fraction to a double, which will be needed later
        public static double ConvertToDouble(Fraction f)
        {
            double asDub = f.Numerator / f.Denominator;
            return asDub;
        }

        // method to find and return common denominator versions of two fractions, to be used later
        // i searched for a good way to return multiple Fraction values, and this was the best I could do- (arrays, tuples, and lists wouldn't accept the Fraction type)
        public static void MakeCommonDenominator(Fraction f1, Fraction f2, out Fraction f1cd, out Fraction f2cd)
        {
            f1cd =
                new Fraction((f1.Numerator * f2.Denominator), (f1.Denominator * f2.Denominator));
            f2cd =
                new Fraction((f2.Numerator * f1.Denominator), (f2.Denominator * f1.Denominator));
        }

        //variables the methods calling common denominator method will need to use
        static Fraction f1new = new Fraction();
        static Fraction f2new = new Fraction();


        /*
         MATH OPS, starting with addition
         --Because each return uses the Fraction constructor, simplification will automatically happen as well
         (except where return is not a fraction at all, such as when doubles are involved)
        */

        public static Fraction operator +(Fraction f1, Fraction f2)
        {
            if (f1.Numerator == 0)
            {
                return f2;
            }
            else if (f2.Numerator == 0)
            {
                return f1;
            }
            else if (f1.Denominator == f2.Denominator)
            {
                return new Fraction(f1.Numerator + f2.Numerator, f1.Denominator);

            }
            else
            {
                // convert to have common denominator, then add
                MakeCommonDenominator(f1, f2, out f1new, out f2new);
                return new Fraction((f1new.Numerator + f2new.Numerator), f2new.Denominator);
            }
        }

        public static Fraction operator +(Fraction f1, int integer)
        {
            if (f1.Numerator == 0)
            {
                return new Fraction(integer, 1);
            }
            else
            {
                int intAsFrac = f1.Denominator * integer;
                return new Fraction((f1.Numerator + intAsFrac), f1.Denominator);
            }
        }

        // if the variables are entered in opposite order, the math doesn't change, so just call other method
        public static Fraction operator +(int integer, Fraction f1)
        {
            return f1 + integer;
        }

        // if a fraction is used with a double - convert to fraction, then call regular addition method
        public static double operator +(Fraction f1, double d1)
        {
            double convertedToDub = ConvertToDouble(f1);
            double result = convertedToDub + d1;
            return result;
        }

        public static double operator +(double d1, Fraction f1)
        {
            return f1 + d1;
        }


        /* the other operators follow similar design pattern with few exceptions, 
         namely that subtraction and division will need slightly more code, because 
         answer changes depending which is the original and what is being taken away*/

        public static Fraction operator -(Fraction f1, Fraction f2)
        {
            if (f1.Numerator == 0)
            {
                return f2;
            }
            else if (f2.Numerator == 0)
            {
                return f1;
            }
            else if (f1.Denominator == f2.Denominator)
            {
                return new Fraction(f1.Numerator - f2.Numerator, f1.Denominator);
            }
            else
            {
                MakeCommonDenominator(f1, f2, out f1new, out f2new);
                return new Fraction((f1new.Numerator - f2new.Numerator), f2new.Denominator);
            }
        }

        // subtracting int from fraction
        public static Fraction operator -(Fraction f1, int integer)
        {
            if (f1.Numerator == 0)
            {
                return new Fraction(integer, -1);
            }
            else
            {
                int intAsFrac = f1.Denominator * integer;
                return new Fraction((f1.Numerator - intAsFrac), f1.Denominator);
            }
        }

        // subtracting fraction from int
        public static Fraction operator -(int integer, Fraction f1)
        {
            if (f1.Numerator == 0)
            {
                return new Fraction(integer, 1);
            }
            else
            {
                int intAsFrac = f1.Denominator * integer;
                return new Fraction((intAsFrac - f1.Numerator), f1.Denominator);
            }
        }

        // using doubles and fractions together
        public static double operator -(Fraction f1, double d1)
        {
            double converted = ConvertToDouble(f1);
            double result = converted - d1;
            return result;
        }

        public static double operator -(double d1, Fraction f1)
        {
            double converted = ConvertToDouble(f1);
            double result = d1 - converted;
            return result;
        }


        public static Fraction operator *(Fraction f1, Fraction f2)
        {
            if (f1.Numerator == 0 || f2.Numerator == 0)
            {
                return new Fraction(0, 1);
            }
            else
            {
                return new Fraction((f1.Numerator * f2.Numerator), (f1.Denominator * f2.Denominator));
            }
        }

        public static Fraction operator *(Fraction f1, int integer)
        {
            if (f1.Numerator == 0)
            {
                return new Fraction(0, 1);
            }
            else
            {
                return new Fraction((f1.Numerator * integer), f1.Denominator);
            }
        }

        public static Fraction operator *(int integer, Fraction f1)
        {
            return f1 * integer;
        }

        public static double operator *(Fraction f1, double d1)
        {
            double converted = ConvertToDouble(f1);
            double result = converted * d1;
            return result;
        }

        public static double operator *(double d1, Fraction f1)
        {
            return f1 * d1;
        }

        public static Fraction operator /(Fraction f1, Fraction f2)
        {
            /*just invert one of the fractions, then multiply - the only tricky part is bec the 
            numerator and denominator themselves cannot be changed, so extra variables are needed.*/
            int denPlaceholder = f2.Denominator;
            int numPlaceholder = f2.Numerator;
            //new fraction with num and den flipped
            Fraction inverted = new Fraction(denPlaceholder, numPlaceholder);

            return inverted * f1;
        }

        // dividing fraction by int
        public static Fraction operator /(Fraction f1, int integer)
        {
            return new Fraction(f1.Numerator, f1.Denominator * integer);
        }

        //dividing int by fraction
        public static Fraction operator /(int integer, Fraction f1)
        {
            return new Fraction((integer * f1.Denominator), f1.Numerator);
        }

        // dividing with doubles
        public static double operator /(Fraction f1, double d1)
        {
            double converted = ConvertToDouble(f1);
            double result = converted / d1;
            return result;
        }

        public static double operator /(double d1, Fraction f1)
        {
            double converted = ConvertToDouble(f1);
            double result = d1 / converted;
            return result;
        }

        // NEGATION METHOD FOR FRACTIONS
        public static Fraction operator -(Fraction f1)
        {
            int negate = 0 - f1.Numerator;
            return new Fraction(negate, f1.Denominator);
        }


        // PROGRAMMING COMPARISON OPERATORS < , >, ==, and !=
        // THESE METHODS INCLUDE COMPARISON OF FRACTION TO SECOND FRACTION, DOUBLE, OR INT
        public static bool operator >(Fraction f1, Fraction f2)
        {
            if (f1.Denominator == f2.Denominator)
            {
                if (f1.Numerator > f2.Numerator)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                MakeCommonDenominator(f1, f2, out f1new, out f2new);
                if (f1new.Numerator > f2new.Numerator)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        public static bool operator >(Fraction f1, double d1)
        {
            double converted = ConvertToDouble(f1);
            if (converted > d1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool operator >(double d1, Fraction f1)
        {
            double converted = ConvertToDouble(f1);
            if (d1 > converted)
            {
                return true;
            }
            else
            {
                return false;
            }

        }

        public static bool operator >(Fraction f1, int integer)
        {
            double converted = ConvertToDouble(f1);
            if (converted > integer)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool operator >(int integer, Fraction f1)
        {
            double converted = ConvertToDouble(f1);
            if (converted > integer)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        // the next batch will be much shorter because they can use already existing code (mostly)

        public static bool operator <(Fraction f1, Fraction f2)
        {
            return f2 > f1;
        }

        public static bool operator <(Fraction f1, double d1)
        {
            return d1 > f1;
        }

        public static bool operator <(double d1, Fraction f1)
        {
            return f1 > d1;
        }

        public static bool operator <(Fraction f1, int integer)
        {
            return integer > f1;
        }

        public static bool operator <(int integer, Fraction f1)
        {
            return f1 > integer;
        }

        //Equals and not equals comparisons
        public static bool operator ==(Fraction f1, Fraction f2)
        {
            if (f1.Denominator == f2.Denominator)
            {
                if (f1.Numerator == f2.Numerator)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                MakeCommonDenominator(f1, f2, out f1new, out f2new);
                if (f1new.Numerator == f2new.Numerator)
                {
                    return true;
                }
                else
                {
                    return false;
                }

            }
        }

        public static bool operator ==(Fraction f1, double d1)
        {
            double converted = ConvertToDouble(f1);
            if (converted == d1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool operator ==(double d1, Fraction f1)
        {
            return f1 == d1;
        }

        public static bool operator ==(Fraction f1, int integer)
        {
            double convertedInt = integer / 1.0;
            return f1 == convertedInt;
        }

        public static bool operator ==(int integer, Fraction f1)
        {
            return f1 == integer;
        }

        // these != methods will utilize code in == methods above
        public static bool operator !=(Fraction f1, Fraction f2)
        {
            if (f1 == f2)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public static bool operator !=(Fraction f1, double d1)
        {
            if (f1 == d1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public static bool operator !=(double d1, Fraction f1)
        {
            return f1 != d1;
        }

        public static bool operator !=(Fraction f1, int integer)
        {
            if (f1 == integer)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public static bool operator !=(int integer, Fraction f1)
        {
            return f1 != integer;
        }
    }
}