# Gnarly Dialog #



```java
final GnarlyDialog gnarlyDialog = new GnarlyDialog(MainActivity.this, GnarlyDialog.GNARLY_DIALOG_TYPE_SUCCESS);
gnarlyDialog.setGnarlyTitleText("Title");
gnarlyDialog.setGnarlyContentText("Content");
gnarlyDialog.setGnarlyPrimaryButtonText("Primary Button");
gnarlyDialog.setGnarlyPrimaryButtonListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Primary button clicked", Toast.LENGTH_SHORT).show();
                    gnarlyDialog.gnarlyDialogDismiss();
                }
            });
gnarlyDialog.setGnarlySecondaryButtonText("Secondary Button");
gnarlyDialog.setGnarlySecondaryButtonListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Secondary button clicked", Toast.LENGTH_SHORT).show();
                    gnarlyDialog.gnarlyDialogDismiss();
                }
            });
gnarlyDialog.setGnarlyShouldDismisOnOutsideTouch(false);
gnarlyDialog.gnarlyDialogShow();
```







## TODO ##
  * Figure out how to upload to Bintray
  * Finish cleaning up library and sample app project
  * Make a pretty Readme here















## Log ##
* 3/21/18
  * Initial commit of library and sample app with success and error dialogs
  
* 5/26/18
  * Cleaning up the library

## TODO ##
  * Add option maybe to use the layout that wraps color all the way around the content or not
  * Change red accent color to be lighter

