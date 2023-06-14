import config.Config;
import model.Singer;
import model.Song;
import service.SingerService;
import service.SongServic;

public class Main {
    static SingerService singerService = new SingerService();
    static SongServic songServic = new SongServic();

    public static void main(String[] args) {

        int choice = 0;
        while (choice != 4) {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.println("******************************************************************");
            System.out.println("mời bạn nhập lựa chọn");
            choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    //quan lí ca si
                    quanlycasi();
                    break;
                case 2:
                    //quan ly bài hat
                    quanlysong();
                    break;
                case 3:
                    //tìm kiếm bài hát
                    break;
                case 4:
                    // Thoát ứng dụng
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
        System.out.println("Ứng dụng kết thúc. Cảm ơn bạn đã sử dụng!");
    }

    private static void quanlycasi() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("******************QUẢN LÝ CA SĨ******************");
            System.out.println("1. Xem danh sách ca sĩ");
            System.out.println("2. Thêm ca sĩ");
            System.out.println("3. Cập nhật thông tin ca sĩ");
            System.out.println("4. Xóa ca sĩ");
            System.out.println("5. Quay lại");
            System.out.println("************************************************");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    //hiện thi ds ca si
                    hienthicasi();

                    break;
                case 2:
                    themmoi();
                    break;
                case 3:
                    editcasi();
                    break;
                case 4:
                    delcasi();
                    break;
                case 5:
                    // Quay lại menu trước đó
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
            if (choice == 5) {
                break;
            }
        }

    }

    public static void hienthicasi() {
        Singer[] listSinger = singerService.getListsinger();
        if (singerService.getSize() == 0) {
            System.out.println("danh sách ca sĩ trống");
        }
        for (int i = 0; i < listSinger.length; i++) {
            if (listSinger[i] == null) {
                continue;
            } else {
                System.out.println(listSinger[i].toString());
            }

        }
    }

    public static void themmoi() {
        Singer newsinger = new Singer();
        Singer[] listsinger = singerService.getListsinger();

        int idMax = 0;  // tạo id lớn nhất
        for (Singer p : listsinger) {
            if (p == null) {
                continue;   // nếu sản phẩm  == null sẽ bỏ qua vòng lặp
            }
            if (idMax < p.getSingerId()) {  // gán max id
                idMax = p.getSingerId();
            }
        }
        newsinger.setSingerId(idMax + 1);
        System.out.print("Tên ca sĩ: ");
        newsinger.setSingerName(Config.scanner().nextLine());
        System.out.println("nhập tuôi:");
        newsinger.setAge(Config.scanner().nextInt());
        System.out.print("Quốc tịch: ");
        newsinger.setNationality(Config.scanner().nextLine());
        System.out.print("Nhập vào giới tinh:");
        System.out.println("true là nam, false: là nữ");
        newsinger.setGender(Config.scanner().nextBoolean());
        System.out.print("Thể loại: ");
        newsinger.setGenre(Config.scanner().nextLine());
        if (singerService.themmoicasi(newsinger)) {
            System.out.println("đã được thêm mới thành công");
        } else System.out.println("theme mới thất bại");
    }

    public static void delcasi() {
        System.out.println("nhập vào id ca sĩ");
        int id = Config.scanner().nextInt();
        if (singerService.delcasi(id)) {
            System.out.println("xóa thành công ca sĩ");
        } else System.out.println("không tồn tai ca sĩ");

    }

    public static void editcasi() {
        System.out.println("nhập vào id ca sĩ");
        int id = Config.scanner().nextInt();
        Singer editsinger = singerService.getSingerById(id);
        if (editsinger == null) {
            System.out.println("không tìm thấy ca sĩ");
        } else {
            editsinger.setSingerId(editsinger.getSingerId());
            System.out.print("Tên ca sĩ: ");
            editsinger.setSingerName(Config.scanner().nextLine());
            System.out.println("nhập tuôi:");
            editsinger.setAge(Config.scanner().nextInt());
            System.out.print("Quốc tịch: ");
            editsinger.setNationality(Config.scanner().nextLine());
            System.out.print("Giới tinh:");
            System.out.println("1.nam");
            System.out.println("2.nữ");
            int gioitinh = Config.scanner().nextInt();
            if (gioitinh == 1) {
                editsinger.setGender(true);
            } else editsinger.setGender(false);

            System.out.print("Thể loại: ");
            editsinger.setGenre(Config.scanner().nextLine());
            if (singerService.updateSinger(editsinger)) {
                System.out.println("update thành công");
            }

        }

    }

    ///song
    private static void quanlysong() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("******************QUẢN LÝ Bài Hát******************");
            System.out.println("1. Xem danh sách bài hát");
            System.out.println("2. Thêm bài hát");
            System.out.println("3. Cập nhật thông tin bài hát");
            System.out.println("4. Xóa bài hát");
            System.out.println("5. Quay lại");
            System.out.println("************************************************");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    //hiện thi song
                    hienthisong();

                    break;
                case 2:
                    themmoisong();
                    break;
                case 3:
                    editsong();
                    break;
                case 4:
                    delsong();
                    break;
                case 5:
                    // Quay lại menu trước đó
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
            if (choice == 5) {
                break;
            }
        }

    }

    public static void hienthisong() {
        Song[] listSong = songServic.getListSong();
        if (songServic.getSize() == 0) {
            System.out.println("danh sách song trống");
        }
        for (int i = 0; i < listSong.length; i++) {
            if (listSong[i] == null) {
                continue;
            } else {
                System.out.println(listSong[i].toString());
            }

        }
    }

    public static void themmoisong() {
        if (singerService.getSize() == 0) {
            System.err.println("Bạn phải thêm ca si trước");
            return;
        }
        Song newsong = new Song();
        Song[] listsong = songServic.getListSong();

        int idMax = 0;  // tạo id lớn nhất
        for (Song p : listsong) {
            if (p == null) {
                continue;   // nếu sản phẩm  == null sẽ bỏ qua vòng lặp
            }
            if (idMax < p.getId()) {  // gán max id
                idMax = p.getId();
            }
        }
        String idsong = "s" + (idMax + 101);
        newsong.setId(idMax + 1);
        newsong.setSongId(idsong);
        System.out.print("Tên bài hat: ");
        newsong.setSongName(Config.scanner().nextLine());
        System.out.println("mô ta:");
        newsong.setDescription(Config.scanner().nextLine());
        System.out.print("Người sáng tác: ");
        newsong.setSongWriter(Config.scanner().nextLine());
        hienthicasi();
        while (true) {
            System.out.println("Nhập id cua ca sĩ");
            int idcasi = Config.scanner().nextInt();
            Singer casi = singerService.getSingerById(idcasi);
            if (casi == null) {
                System.err.println("Id không tôn tại, vui lòng nhập lại");
            } else {
                newsong.setSinger(casi);
                break;
            }
        }
        newsong.setSongStatus(true);
        if (songServic.themmoibaihat(newsong)) {
            System.out.println("đã được thêm mới thành công");
        } else System.out.println("theme mới thất bại");
    }

    public static void delsong() {
        System.out.println("nhập vào songid bài hat");
        String id = Config.scanner().nextLine();
        if (songServic.delsong(id)) {
            System.out.println("xóa thành công bài hát");
        } else System.out.println("không tồn tại bài hát");

    }

    public static void editsong() {
        System.out.println("nhập vào idsong bài hat");
        String id = Config.scanner().nextLine();
        Song editsong = songServic.getSongById(id);
        if (editsong == null) {
            System.out.println("không tìm thấy ca sĩ");
        } else {
            editsong.setSongId(editsong.getSongId());
            System.out.print("Tên bài hat: ");
            editsong.setSongName(Config.scanner().nextLine());
            System.out.println("mô ta:");
            editsong.setDescription(Config.scanner().nextLine());
            System.out.print("Người sáng tác: ");
            editsong.setSongWriter(Config.scanner().nextLine());
            hienthicasi();
            while (true) {
                System.out.println("Nhập id cua ca sĩ");
                int idcasi = Config.scanner().nextInt();
                Singer casi = singerService.getSingerById(idcasi);
                if (casi == null) {
                    System.err.println("Id không tôn tại, vui lòng nhập lại");
                } else {
                    editsong.setSinger(casi);
                    break;
                }
            }
            editsong.setSongStatus(true);
            if (songServic.updateSong(editsong)) {
                System.out.println("update thành công");
            }

        }

    }
}