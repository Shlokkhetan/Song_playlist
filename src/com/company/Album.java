package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Album {
    private String AlbumName;
    private String Artist;
    ArrayList<Song> albumsongs;

    public Album(String albumName, String artist) {
        AlbumName = albumName;
        Artist = artist;
        albumsongs = new ArrayList<>();
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public ArrayList<Song> getAlbum() {
        return albumsongs;
    }

    public boolean addSongtoAlbum(String name, Double duration){

        if(searchSong(name) != null){
            System.out.println("The song already exists");
            return  false;
        }else{
            this.albumsongs.add(new Song(name,duration));
            return true;
        }

    }

    public Song searchSong(String name){
//        ListIterator<Song> li = this.album.listIterator();
//
//        while(li.hasNext()){
//            if(li.next().getName().equals(name)) {
//                li.previous();
//
//                return true;
//            }
//
//        }
//        return false;

        for(Song checkedSong: this.albumsongs){
            if(checkedSong.getName().equals(name)){
                return checkedSong;

            }

        }
        return null;
    }



    public  boolean addToPlaylist(int trackNo,  LinkedList<Song> playlist){
        int track = trackNo-1;
        if(track>=0 && track<albumsongs.size()){
            playlist.add(this.albumsongs.get(track));
            return true;
        }
        return false;

    }

    public boolean addToPlayList(String name, LinkedList<Song> playlist){
        if(albumsongs.contains(searchSong(name)) == false) {
            System.out.println("The song does not exist in any album");
            return false;
        }

        playlist.add(searchSong(name));
        return true;

    }





}
