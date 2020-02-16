Project title:trackME(Messaging + Location tracker)


The project title make sense about the location and messaging(chatting) features of user.
Firstly, user have to register, after that they have acess to his account.The user can add friend
and can conversation with his friend. This application helps to built trust and save tile for waiting user
and also can make plans for meeting destination.

Geeting started
This document will help you to guide and enhances the information about the feature. Y
ou have to follow below git hub link:

Android:
<https://github.com/dpgaire/trackME.git>

API Link:
<https://github.com/softwarica-github/t2-backend-api-dpgaire.git>

Video-Link
<https://youtu.be/A499r6lhyx0>

Running the code by clonning this link in your own system and open it and run it.


Features:
The user login and register.up
The user can add firend and have conversation with them.
The user can view his profile
The user can update his profile
The user can remove or delete his friend list.
The user of vibratation sernsor also implemented in order to alert user for invalid input information.
The user have acess to view his friend location.

Rest client: Retrofit
Retrofit is a REST Client library (Helper Library) used in Android and Java to create an HTTP request and 
also to process the HTTP response from a REST API. It was created by Square, 
you can also use retrofit to receive data structures other than JSON, for example SimpleXML and Jackson.

REST Client in our case is the Retrofit library that is used on the client side (Android) to 
make HTTP request to REST API,
in our case, The Movie DB API and also process the response.

To use Retrofit in your Android Application, you’ll need 3 major classes.
An Interface which defines the HTTP operations (Functions or methods)
According to Square, creators of Retrofit documentation, Retrofit turns your HTTP API into a Java interface. Sample codes for the interface and the method declared in it are as below:

public interface GitHubService {
@GET("users/{user}/repos")
Call<List<Repo>> listRepos(@Path("user") String user);
@GET("group/{id}/users")
Call<List<User>> groupList(@Path("id") int groupId);
}
Every method inside an interface represents one possible API call. It must have a HTTP annotation (GET, POST, etc.) to specify the request type and the relative URL. The return value wraps the response in a Call object with the type of the expected result.

Query parameters can also be added to a method.

@GET(“group/{id}/users”)
Call<List<User>> groupList(@Path(“id”) int groupId, @Query(“sort”) String sort);
You can use replacement blocks and query parameters to adjust the URL. A replacement block is added to the relative URL with {}. With the help of the @Path annotation on the method parameter, the value of that parameter is bound to the specific replacement block.

2. A Retrofit class which generates an implementation of the GitHubService interface. The below sample code would be inside the Retrofit class and this is how it creates an instance of Retrofit and implements the listRepos() method that’s in the GitHubService Interface.

Retrofit retrofit = new Retrofit.Builder()
.baseUrl(“https://api.github.com/")
.build();
GitHubService service = retrofit.create(GitHubService.class);
Call<List<Repo>> repos = service.listRepos(“Gino Osahon”);
3. The last of the 3 needed class is a simple POJO that matches each field i
n the JSON response object gotten from querying an API. It’s a simple class with getter and setter methods for each fields. We’ll see sample codes later.

Retrofit Converters

Retrofit Converters are like an agreement between and Android client and the Server on the format on which data will be represented. Both parties can agree that for our communication, the format for data transfer will be JSON, as in our case in this tutorial. Remember i said apart from the JSON structure converter, we have others and here are some supported by Retrofit.

Gson:

Gson is for JSON mapping and can be added with the following dependency:

compile ‘com.squareup.retrofit2:converter-gson:2.2.0’


