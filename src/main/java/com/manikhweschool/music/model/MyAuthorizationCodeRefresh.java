package com.manikhweschool.music.model;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRefreshRequest;
import com.wrapper.spotify.requests.data.library.GetCurrentUsersSavedAlbumsRequest;
import com.wrapper.spotify.requests.data.player.GetCurrentUsersRecentlyPlayedTracksRequest;
import com.wrapper.spotify.requests.data.playlists.GetListOfCurrentUsersPlaylistsRequest;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistCoverImageRequest;

import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
//Create an instance of this class Finally.
public class MyAuthorizationCodeRefresh {
  private static String clientId;
  private static String clientSecret;
  private static String refreshToken;

  private static SpotifyApi spotifyApi;
  private static AuthorizationCodeRefreshRequest authorizationCodeRefreshRequest;

  public static void createMyAuthorizationCodeRefresh(
  String clientId, String clientSecret, String refreshToken) {
	  
	  MyAuthorizationCodeRefresh.clientId = clientId;
	  MyAuthorizationCodeRefresh.clientSecret = clientSecret;
	  MyAuthorizationCodeRefresh.refreshToken = refreshToken;
	  
	  spotifyApi = new SpotifyApi.Builder()
	    .setClientId(MyAuthorizationCodeRefresh.clientId)
        .setClientSecret(MyAuthorizationCodeRefresh.clientSecret)
	    .setRefreshToken(MyAuthorizationCodeRefresh.refreshToken)
	    .build();
	  
	  authorizationCodeRefreshRequest = spotifyApi.authorizationCodeRefresh()
	  .build();
  }
  
  public static void authorizationCodeRefresh_Sync() {
    try {
      final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRefreshRequest.execute();

      /* This is where i start making requests 
       * to the spotify api. After each request
       * i need to reset my access token.
       * */
      GetCurrentUsersRecentlyPlayedTracksRequest.Builder recentlyPlayedTracks = spotifyApi.getCurrentUsersRecentlyPlayedTracks();   
      GetListOfCurrentUsersPlaylistsRequest.Builder userPlaylists = spotifyApi.getListOfCurrentUsersPlaylists();  
      GetCurrentUsersSavedAlbumsRequest.Builder userSavedAlbums = spotifyApi.getCurrentUsersSavedAlbums();
      GetPlaylistCoverImageRequest.Builder playlistImage = spotifyApi.getPlaylistCoverImage("playlistId");
      
      
      
      
      
      // Set access and refresh token for further "spotifyApi" object usage
      spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());

      System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());
      System.out.println("==================End Of Step Three===============================");
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void authorizationCodeRefresh_Async() {
    try {
      final CompletableFuture<AuthorizationCodeCredentials> authorizationCodeCredentialsFuture = authorizationCodeRefreshRequest.executeAsync();

      // Thread free to do other tasks...

      // Example Only. Never block in production code.
      final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeCredentialsFuture.join();

      // Set access token for further "spotifyApi" object usage
      spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());

      System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());
    } catch (CompletionException e) {
      System.out.println("Error: " + e.getCause().getMessage());
    } catch (CancellationException e) {
      System.out.println("Async operation cancelled.");
    }
  }
}

