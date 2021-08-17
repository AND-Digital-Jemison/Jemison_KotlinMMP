# Android basics


## Terminology

### Activity

- provides the **window in which your app draws its UI**. 
- Typically, an Activity takes up the whole screen of your running app. 
- Every app has one or more activities. 
- The top-level or first activity is often called the `MainActivity` and is provided by the project template. 

### Fragment 

- represents a **reusable portion of your app's UI**. 
- defines and manages its own layout
- has its own `lifecycle`, 
- can handle its own input events. 
Fragments cannot live on their own--they must be hosted by activity or another fragment. 
The fragment’s view hierarchy becomes part of or attaches to, the host’s view hierarchy.

### Intent 

- is an **abstract description of an operation to be performed**.
- provides a facility for performing late runtime binding between the code in different applications
Its **most significant use is in the launching of activities**, where it can be thought of as the `glue between activities`. 
It is basically a passive data structure holding an abstract description of an action to be performed.



## Layout

### units

Google recommends to use there units for fluid layouts instead of pixels

*Layout itself:* 

`DP` 
- Density-independent Pixels
- each device have different pixel density, android will adjust the sizing accordingly


*Fonts:*

`SP` 
- Scale-independent Pixels 
- android will adjust the font size according to user scaling preference 
    
