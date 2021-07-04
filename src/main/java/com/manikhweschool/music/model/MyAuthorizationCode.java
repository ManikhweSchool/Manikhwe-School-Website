package com.manikhweschool.music.model;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

// Create an instance of this class secondly.
public class MyAuthorizationCode {
  private static String clientId;
  private static String clientSecret;
  private static URI redirectUri;
  private static String code;

  private static SpotifyApi spotifyApi;
  private static AuthorizationCodeRequest authorizationCodeRequest;

  public static void createMyAuthorizationCode(String clientId, 
  String clientSecret, URI redirectUri, String code) {
	  MyAuthorizationCode.clientId = clientId;
	  MyAuthorizationCode.clientSecret = clientSecret;
	  MyAuthorizationCode.redirectUri = redirectUri;
	  MyAuthorizationCode.code = code;
	  
	  spotifyApi = new SpotifyApi.Builder()
	  .setClientId(MyAuthorizationCode.clientId)
      .setClientSecret(MyAuthorizationCode.clientSecret)
	  .setRedirectUri(MyAuthorizationCode.redirectUri)
	  .build();
	  
	  authorizationCodeRequest = 
	  spotifyApi.authorizationCode(MyAuthorizationCode.code)
	  .build();
  }
  
  public static void goToThirdStep(String refreshToken) {
	  
	  MyAuthorizationCodeRefresh.createMyAuthorizationCodeRefresh(
	  clientId, clientSecret, refreshToken);
      MyAuthorizationCodeRefresh.authorizationCodeRefresh_Sync();
  }
  
  public static void authorizationCode_Sync() {
    try {
    	
      final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();
      
      System.out.println("Access Token - " + authorizationCodeCredentials.getAccessToken());
      System.out.println("Refresh Token - " + authorizationCodeCredentials.getRefreshToken());
      
      // Set access and refresh token for further "spotifyApi" object usage
      spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
      spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

      System.out.println("Specified Scopes : " + authorizationCodeCredentials.getScope());
      
      System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());
      System.out.println("==================End Of Step Two===============================");
      goToThirdStep(authorizationCodeCredentials.getRefreshToken());
      
    
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void authorizationCode_Async() {
    try {
      final CompletableFuture<AuthorizationCodeCredentials> authorizationCodeCredentialsFuture = authorizationCodeRequest.executeAsync();

      // Thread free to do other tasks...

      // Example Only. Never block in production code.
      final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeCredentialsFuture.join();

      // Set access and refresh token for further "spotifyApi" object usage
      spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
      spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

      System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());
    } catch (CompletionException e) {
      System.out.println("Error: " + e.getCause().getMessage());
    } catch (CancellationException e) {
      System.out.println("Async operation cancelled.");
    }
  }
}

