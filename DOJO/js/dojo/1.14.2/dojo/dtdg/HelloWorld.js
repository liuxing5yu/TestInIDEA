//Summary: An example HelloWorld dijit that illustrates Dojo's basic dijit
//design pattern

//The first line of any module file should have exactly one dojo.provide
//specifying the resource and any membership in parent modules. The name
//of the resource should be the same as the .js file.
dojo.provide("dtdg.HelloWorld");

//Always require resources before you try to use them. We're requiring these
//two resources because they're part of our dijit's inheritance hierarchy.
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");

//The feature rich constructor that allows us to declare Dojo "classes".
dojo.declare(
    "dtdg.HelloWorld",

    //dijit._Widget is the prototypical ancestor that provides important method
    //stubs like the ones below.
    //dijit._Templated is then mixed in and overrides dijit._Widget's
    //buildRendering method, which constructs the UI for the dijit from
    //a template.
    [dijit._Widget, dijit._Templated],
    {
        //Path to the template of this dijit. dijit._Templated uses this to
        //snatch the template from the named file via a synchronous call.
        templatePath: dojo.moduleUrl("dtdg", "templates/HelloWorld.html")
    }
);