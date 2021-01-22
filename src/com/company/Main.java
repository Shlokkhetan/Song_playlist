package com.company;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

            // Create a program that implements a playlist for songs
            // Create a Song class having Title and Duration for a song.
            // The program will have an Album class containing a list of songs.
            // The albums will be stored in an ArrayList
            // Songs from different albums can be added to the playlist and will appear in the list in the order
            // they are added.
            // Once the songs have been added to the playlist, create a menu of options to:-
            // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
            // List the songs in the playlist
            // A song must exist in an album before it can be added to the playlist (so you can only play songs that
            // you own).
            // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
            // started tracking the direction we were going.
            // As an optional extra, provide an option to remove the current song from the playlist
            // (hint: listiterator.remove()

            Album album = new Album("Stormbringer", "Deep Purple");
            album.addSongtoAlbum("Stormbringer", 4.6);
            album.addSongtoAlbum("Love don't mean a thing", 4.22);
            album.addSongtoAlbum("Holy man", 4.3);
            album.addSongtoAlbum("Hold on", 5.6);
            album.addSongtoAlbum("Lady double dealer", 3.21);
            album.addSongtoAlbum("You can't do it right", 6.23);
            album.addSongtoAlbum("High ball shooter", 4.27);
            album.addSongtoAlbum("The gypsy", 4.2);
            album.addSongtoAlbum("Soldier of fortune", 3.13);
            albums.add(album);

            album = new Album("For those about to rock", "AC/DC");
            album.addSongtoAlbum("For those about to rock", 5.44);
            album.addSongtoAlbum("I put the finger on you", 3.25);
            album.addSongtoAlbum("Lets go", 3.45);
            album.addSongtoAlbum("Inject the venom", 3.33);
            album.addSongtoAlbum("Snowballed", 4.51);
            album.addSongtoAlbum("Evil walks", 3.45);
            album.addSongtoAlbum("C.O.D.", 5.25);
            album.addSongtoAlbum("Breaking the rules", 5.32);
            album.addSongtoAlbum("Night of the long knives", 5.12);
            albums.add(album);

            LinkedList<Song> playlist = new LinkedList<Song>();
            albums.get(1).addToPlayList("C.O.D.",playlist);
            albums.get(1).addToPlayList("Inject the venom",playlist);
            albums.get(1).addToPlayList("Evil walks",playlist);
            albums.get(0).addToPlayList("Stormbringer",playlist);
            albums.get(0).addToPlayList("Holy man",playlist);

            play(playlist);






            // write your code here
    }
    public static void play(LinkedList<Song> playlist){
            ListIterator<Song> iterator = playlist.listIterator();
            Scanner scanner = new Scanner(System.in);
            boolean quit = false;
            boolean forward = true;

            if(playlist.size() == 0){
                    System.out.println("Playlist is empty");
                    return;
            }else{
                    System.out.println("Now playing: " + iterator.next().toString());
            }

            while(!quit){
                    System.out.println("Enter your choice");
                    printOptions();
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice){
                            case 0 :
                                    System.out.println("The playlist is complete");
                                    quit = true;
                                    break;
                            case 1:
                                    if(!forward) {
                                            if (iterator.hasNext()) {
                                                    iterator.next();
                                            }
                                            forward = true;
                                    }
                                    if(iterator.hasNext()){
                                            System.out.println("Now Playing: " + iterator.next().toString());

                                    }else{
                                            System.out.println("Reached the end of the list");
                                            forward = false;


                                    }

                                    break;
                            case 2:
                                    if(forward){
                                            if(iterator.hasPrevious()){
                                                    iterator.previous();
                                            }
                                            forward = false;
                                    if(iterator.hasPrevious()){
                                            System.out.println("Now playing : " + iterator.previous().toString());
                                    }else{
                                            System.out.println("You have reached the start of the playlist");
                                            forward = true;
                                    }




                                    }
                                    break;
                            case 3:
                                    if(forward){
                                            if(iterator.hasPrevious()){
                                                    System.out.println("Now Playing: " + iterator.previous().toString());
                                                    forward = false;

                                            }else{
                                                    System.out.println("We are at the start of the list");
                                                    forward = true;
                                            }

                                    }else{
                                            if(iterator.hasNext()){
                                                    System.out.println("Now replaying : " + iterator.next().toString());
                                                    forward = true;
                                            }else{
                                                    System.out.println("We are at the end of the list");
                                                    forward = false;
                                            }

                                    }
                                    break;

                            case 4:
                                    printList(playlist);
                                    break;
                            case 5:
                                    printOptions();
                                    break;
                    }

            }




    }

    private static void printOptions(){
            System.out.println("Here are the options: \n" +
                    "0: Quit\n" +
                    "1: next\n" +
                    "2: previous\n" +
                    "3: Replay the current song\n" +
                    "4: List songs in the playlist\n" +
                    "5: print options");
    }

    private static void printList(LinkedList<Song> playlist){
            Iterator<Song> iterator = playlist.iterator();

            System.out.println("============");
            while(iterator.hasNext()){

                    System.out.println(iterator.next().toString());

            }
            System.out.println("============");
    }

//    public static LinkedList next(LinkedList<Song> playlist){
//            ListIterator<Song> iterator = playlist.listIterator();
//            if(iterator.hasNext() == false){
//                    System.out.println("playlist has reached its end");
//                    return null;
//            }else{
//                    iterator.next();
//                    iterator.next();
//                    return playlist;
//            }
//    }


}
