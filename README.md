# Ktor Backend Server 
<p> Architecture : Model - View - ViewModel  <br>
Language: Kotlin<br>

<p>This application starts a ktor backend wich receives requests to insert dog in server, remove dog, list dogs. All via HTTP methods. The changes are reflected live in the
main activity layout.</p>
Use cases:
<ul>
<li>Init (inserts 3 dogs in server)</li>
<li>Insert Dog</li>
<li>List Dogs</li>
<li>Remover Dog</li>
</ul>

Implements:<br></p>
<ul>
<li>Gson library to handle JSON objects</li>
<li>Coil library to load Images. This library uses coroutines</li>
<li>Koin library for dependency injection</li>
<li>Desing patterns like adapter, singleton</li>
</ul>
<p> In this project you migth find UI implements like:<p>
<ul>
<li>Set up different styles in themes file and costumize the views</li>
<li>Create the app icon using the  Image asset creator from the android studio</li>
</ul>
<p> 
This application has an activity. where you can start / stop the ktor server.<br>
The viewModel use dependency injection, and LiveData to comunicate events.
App layers and classes: <br> 
 -> model. * dataclasses. This class holds the different data classes used to show and save dog objects, and some convertion methods from one class to another. <br> 
 -> server  * HttpService extends android service class, inits ktor server as an android service.<br>
            * RequestHandler.This class handles the api requests and routes for the ktor server.<br>
            * ServerManager extends viewModel, to connect liveData with Actitivy. Interacts with Ktor Server.<br>
 -> Utils.  * Extensions. Holds some extensions functions like validate user input for edittext.<br>
 -> Views   * Holds the main activity and Recycler View Adapter.<br>
 Some ScreenShots:
  <div>
    <img src="https://user-images.githubusercontent.com/100162759/204053761-28f4ab23-486d-428c-8143-fb421562d71a.png" width=30% height=30%>
    <img src="https://user-images.githubusercontent.com/100162759/204053769-b700ee5a-9d65-404c-bb05-b19225343bec.png" width=30% height=30%>
    <img src="https://user-images.githubusercontent.com/100162759/204053772-eebf9673-0c57-48f9-90b3-a8e1059da2d9.png" width=30% height=30%>
</div>
