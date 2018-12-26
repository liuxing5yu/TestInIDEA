/*
   The dojo.provide statement specifies that this .js source file provides a
   dtdg.foo module. Semantically, the dtdg.foo module also provides a namespace for
   functions that are included in the module On disk, this file
   would be named foo.js and be placed inside of a dtdg directory.
*/
dojo.provide("dtdg.foo");

//Note that the function is relative to the module's namespace
dtdg.foo.fibonacci = function(x) {
    if (x < 0)
        throw Exception("Illegal argument");

    if (x <= 1)
        return x;

    return dtdg.foo.fibonacci(x-1) + dtdg.foo.fibonacci(x-2);
}