package Uji;

import exception.ValidationException;
import model.Ruang;

public class UjiEntity {

    public static void main(String[] args) {

        coba("Data lengkap dan benar",
                new Ruang("R001", "Laboratorium Komputer", 30, 1));

        coba("Nama kosong",
                new Ruang("R002", "", 25, 1));

        coba("Kapasitas nol",
                new Ruang("R003", "Ruang Kuliah", 0, 1));
    }

    private static void coba(String keterangan, Ruang r) {
        try {
            r.validasi();

            System.out.println(
                    "DITERIMA : " + keterangan + " -> " + r.label()
            );

        } catch (ValidationException e) {

            System.out.println(
                    "DITOLAK : " + keterangan + " -> "
                            + e.pesanPengguna()
            );
        }
    }
}