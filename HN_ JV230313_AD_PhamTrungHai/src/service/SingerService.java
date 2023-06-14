package service;

import model.Singer;

public class SingerService {
    private Singer[] listsinger = new Singer[10];
    private int size = 0;

    public Singer[] getListsinger() {
        return listsinger;
    }

    public int getSize() {
        return size;
    }

    public boolean themmoicasi(Singer newsinger) {
        if (size > 10) {
            System.out.println("thêm mới không thành công số lượng ca sĩ đầy thử lại sau");
            return false;
        }
        for (int i = 0; i < listsinger.length; i++) {
            if(listsinger[i]==null){
                listsinger[i]=newsinger;
                size++;
                System.out.println(newsinger.toString());
                return true;
            }
        }
return false;

    }
    public boolean delcasi(int id){
        for (int i = 0; i < listsinger.length ; i++) {
            if(listsinger==null){
                continue;
            }

         if(listsinger[i].getSingerId()==id){
             System.out.println(listsinger[i].toString());
             listsinger[i]=null;
             size--;
             return true;
         }
        } return false;
    }
    public Singer getSingerById(int singerId) {
        for (Singer singer : listsinger) {
            if(singer==null){ continue;}
            if (singer.getSingerId() == singerId) {
                return singer;
            }
        }
        return null;
    }
    public boolean updateSinger(Singer updatedSinger) {
        for (int i = 0; i < listsinger.length ; i++) {
            if(listsinger==null){
                continue;
            }

            if(listsinger[i].getSingerId()==updatedSinger.getSingerId()){

                listsinger[i]=updatedSinger;
                return true;
            }
        } return false;
    }
}