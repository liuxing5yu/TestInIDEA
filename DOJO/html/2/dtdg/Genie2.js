dojo.provide("dtdg.Genie2");

//define the object
dtdg.Genie2 = function () {
}

//and now extend it
dojo.extend(dtdg.Genie2, {
    _predictions: [
        "As I see it, yet",
        "Ask again later",
        "Better not tell you now",
        "Cannot predict now",
        "Concentrate and ask again",
        "Don't count on it",
        "It is certain",
        "It is decidedly so",
        "Most likely",
        "My reply is no",
        "My sources say no",
        "Outlook good",
        "Outlook not so good",
        "Reply hazy, try again",
        "Signs point to yes",
        "Very doubtful",
        "Without a doubt",
        "Yes",
        "Yes - definitely",
        "You may rely on it"
    ],

    initialize: function () {
        var label = document.createElement("p");
        label.innerHTML = "Ask a question. The genie knows the answer...";

        var question = document.createElement("input");
        question.size = 50;

        var button = document.createElement("button");
        button.innerHTML = "Ask!";
        button.onclick = function () {
            alert(dtdg.Genie2.prototype._getPrediction());
            question.value = "";
        }

        var container = document.createElement("div");
        container.appendChild(label);
        container.appendChild(question);
        container.appendChild(button);

        dojo.body().appendChild(container);
    },

    _getPrediction: function () {
        //get a number betweeen 0 and 19 and index into predictions
        var idx = Math.round(Math.random() * 19)
        return this._predictions[idx];
    }
});