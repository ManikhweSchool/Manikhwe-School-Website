package com.manikhweschool.music.model;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class MyAuthorizationCodePKCEUri {
	private static final String clientId = "bac757d75af0458e9eda632244424997";
	private static final URI redirectUri = SpotifyHttpManager.makeUri("https://manikhwe-programming-school.herokuapp.com/");
  // I don't have it yet.
  private static final String codeChallenge = "w6iZIj99vHGtEx_NVl9u3sthTN646vvkiP8OMCGfPmo";

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
    .setClientId(clientId)
    .setRedirectUri(redirectUri)
    .build();
  private static final AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodePKCEUri(codeChallenge)
    //.state("x4xkmn9pu3j6ukrs8n")
    //.scope("user-read-birthdate,user-read-email")
    //.show_dialog(true)
    .build();

  public MyAuthorizationCodePKCEUri(){
	    authorizationCodeUri_Sync();
	    authorizationCodeUri_Async();
  }
  
  public static void authorizationCodeUri_Sync() {
    final URI uri = authorizationCodeUriRequest.execute();

    System.out.println("URI: " + uri.toString());
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

