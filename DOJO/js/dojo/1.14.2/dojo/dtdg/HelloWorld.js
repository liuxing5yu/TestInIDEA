dojo.provide("dtdg.HelloWorld");

dojo.require("dijit._Widget");
dojo.require("dijit._Templated");

dojo.declare(
    "dtdg.HelloWorld",
    [dijit._Widget, dijit._Templated],
    {
        templateString:
            "<span class='hello_class' dojoAttachEvent='onmouseover:onMouseOver, onmouseout: onMouseOut'>" +
            "Hello World</span>",

        onMouseOver: function (evt) {
            dojo.addClass(this.domNode, 'hello_class');
            console.log("applied hello_class...");
            console.log(evt);
        },

        onMouseOut: function (evt) {
            dojo.removeClass(this.domNode, 'hello_class');
            console.log("removed hello_class...");
            console.log(evt);
        }

    }
)
;