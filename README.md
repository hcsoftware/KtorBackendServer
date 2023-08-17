# Ktor Backend API Server 
<p> Architecture : Model - View - ViewModel  <br>
Language: Kotlin<br>

<p>This application manages a backend API server wich receives requests to insert dogs, remove dogs, and list dogs. All via HTTP request methods. The changes are reflected live in the main activity layout. The server runs as an android service.</p>
Use cases:
<ul>
<li>Init (inserts 3 dogs in server)</li>
<li>Insert Dog</li>
<li>List Dogs</li>
<li>Remove Dog</li>
</ul>

Implements:<br></p>
<ul>
<li>Ktor framework for backend API Server. Read more in -> https://ktor.io/docs/welcome.html</li> 
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
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/100162759/261441045-6ded4c90-4c0a-4ce4-87b6-69fd3f546905.png" width=30% height=30%>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/100162759/261441032-126463ce-ecc0-4464-bcd1-078158ec22f9.png" width=30% height=30%>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/100162759/261441050-2da680d5-dcb7-4e18-bb67-5b386e0327c1.png" width=30% height=30%>
</div>



