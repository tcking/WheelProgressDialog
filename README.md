WheelProgressDialog
===================

progress dailog using wheel style in android 

![Sample Image](https://github.com/tcking/WheelProgressDialog/raw/master/sample.gif "An example implementation")


usage:

```
wheelProgressDialog=new WheelProgressDialog(this);
wheelProgressDialog.message("game on !").show();

...

wheelProgressDialog.progress(i++).message("processing:"+i+"%");

...

wheelProgressDialog.dismiss();

```

this is a dialog wrapper for [ProgressWheel](https://github.com/Todd-Davies/ProgressWheel) 
