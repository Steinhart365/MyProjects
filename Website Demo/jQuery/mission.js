Vue.component('suggestions', {

    //props for data accessed later
    props: ['deadline', 'today', 'allSuggestions'],

    //this template for the form uses v-model to link the suggestion and rating entered to our entry and rating 
    //it also links to its own special css pg for some formatting.
    template: `
        <div>
        <link rel="stylesheet" type="text/css" href="../styling/component.css">
         <form id="suggestionBox" @submit.prevent="confirm">
             <h5> A Yeshiva that values your input </h5>
             <p> Below is our suggestion box, where any current student or applicant can anonymously post any ideas on how we could be better or a new program we could try. We carefully read each and every comment left, and the hanhallah consider all proposals. So thank you for helping us improve. </p>       
             <textarea class="suggestifier" name="ideas" cols="30" rows="10" v-model="entry" required>On {{ today }} {{ entry }}</textarea>
                <br>
                <div id="selector">
                <label for="rating"> How important is this to you?</label> 
                <select name="rating" id="rating">
                    <option value="5">Extremely</option>
                    <option value="4">Very</option>
                    <option value="3">Pretty</option>
                    <option value="2">Moderately</option>
                    <option value="1">Just a Suggestion</option>
                </select>
            </div>
                <br><br>
                 <input type="submit" id="submitter" value="suggest"></input>
             </form> 

          <section style="display: none;" id="posted">
            <h6>Previous suggestions: <br> {{allSuggestions}}</h6>
            </section>
        </div> 
        `,

    data() {
        return {
            entry: null
        }
    },


    //I have nowhere to send the submitted suggestions to, but on submission I instead just post a method confirming we recieved it
    // and put the suggestion in an invisible array for my eyes only 

    methods: {
        confirm() {
            let suggestion = {
                review: this.entry + ", urgency: " + this.rating
            }
            this.$emit('suggestion_made', suggestion)
            this.entry = "submitted, thank you. Anything else?"
        }
    }
});


var main = new Vue({
    el: '#main',

    data: {
        company: 'YEVE-',
        ideal: 'Raising the Giants of Tommorrow',
        today: new Date(),
        deadline: new Date(2020, 06, 25),
        styler: {
            color: 'purple',
            border: ' 2px dashed brown'
        },
        allSuggestions: []
    },

    methods: {
        confirmation(suggestion) {
            allSuggestions.push(suggestion)
        }
    },

    computed: {
        headline() {
            return this.company + ' ' + this.ideal
        }

    }

});