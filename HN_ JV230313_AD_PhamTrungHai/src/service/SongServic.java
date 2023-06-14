package service;


import model.Song;

public class SongServic {
    private Song[] listSong = new Song[10];
    private int size = 0;

    public Song[] getListSong() {
        return listSong;
    }

    public int getSize() {
        return size;
    }

    public boolean themmoibaihat(Song newsong) {
        if (size > 10) {
            System.out.println("thêm mới không thành công số lượng ca sĩ đầy thử lại sau");
            return false;
        }
        for (int i = 0; i < listSong.length; i++) {
            if(listSong[i]==null){
                listSong[i]=newsong;
                size++;
                System.out.println(newsong.toString());
                return true;
            }
        }
        return false;

    }
    public boolean delsong(String id){
        for (int i = 0; i < listSong.length ; i++) {
            if(listSong==null){
                continue;
            }

            if(listSong[i].getSongId().equals(id)){
                System.out.println(listSong[i].toString());
                listSong[i]=null;
                size--;
                return true;
            }
        } return false;
    }
    public Song getSongById(String songid) {
        for (Song song : listSong) {
            if(song==null){ continue;}
            if (song.getSongId().equals(songid)) {
                return song;
            }
        }
        return null;
    }
    public boolean updateSong(Song updatedSong) {
        for (int i = 0; i < listSong.length ; i++) {
            if(listSong==null){
                continue;
            }

            if(listSong[i].getSongId()==updatedSong.getSongId()){

                listSong[i]=updatedSong;
                return true;
            }
        } return false;
    }
}
