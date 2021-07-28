package com.manikhweschool.music.model;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

// Create an instance of this class firstly.
public class MyAuthorizationCodeUri {
	private static String clientId;
	private static String clientSecret;
	private static URI redirectUri;

  private static SpotifyApi spotifyApi;
  
  private static AuthorizationCodeUriRequest authorizationCodeUriRequest;

  public static void createMyAuthorizationCodeUri(
  String clientId, String clientSecret) {
	  
	  MyAuthorizationCodeUri.clientId = clientId;
	  MyAuthorizationCodeUri.clientSecret = clientSecret;
	  redirectUri = SpotifyHttpManager.makeUri("https://www.manikhweschool.com/spotifyredirect");
	  //redirectUri = SpotifyHttpManager.makeUri("http://localhost:8080/index");
	    
	  spotifyApi = new SpotifyApi.Builder()
	    .setClientId(MyAuthorizationCodeUri.clientId)
        .setClientSecret(MyAuthorizationCodeUri.clientSecret)
	    .setRedirectUri(redirectUri)
	    .build();
	  
	  authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
	  //.state("x4xkmn9pu3j6ukrs8n")
		  .response_type("code")
		  .show_dialog(true)
		  .scope("user-read-recently-played," // Read access to a user’s recently played tracks.
			  		+ "user-top-read," // Read access to a user's top artists and tracks.
			  		+ "playlist-read-private," // Read access to user's private playlists.
			  		+ "user-library-read," // Read access to a user's library.
			  		+ "playlist-read-collaborative," // Include collaborative playlists when requesting a user's playlists.
			  		+ "user-read-email") // Read access to user’s email address.
		   .build();
	  
  }
  
  public static void authorizationCodeUri_Sync() {
    final URI uri = authorizationCodeUriRequest.execute();

    String codeAndState = uri.toString();

    System.out.println("\nURI: " + codeAndState);
    System.out.println("==================End Of Step One===============================");
  }
  
  public static boolean secondStep(String code) {
	  boolean returnValue = MyAuthorizationCode.createMyAuthorizationCode(clientId, 
	  clientSecret, redirectUri,code);
			    
	  MyAuthorizationCode.authorizationCode_Sync();
	  
	  return returnValue;
  }

  public static void authorizationCodeUri_Async() {
	  try {
	      final CompletableFuture<URI> uriFuture = authorizationCodeUriRequest.executeAsync();

	      // Thread free to do other tasks...

	      // Example Only. Never block in production code.
	      final URI uri = uriFuture.join();

	      System.out.println("URI: " + uri.toString());
	  } catch (CompletionException e) {
	      System.out.println("Error: " + e.getCause().getMessage());
	  } catch (CancellationException e) {
	      System.out.println("Async operation cancelled.");
	  }
   }
}

