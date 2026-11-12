package model;

import exception.ValidationException;

public class Ruang extends BaseEntity {

    private String kode;
    private String nama;
    private int kapasitas;
    private int gedungId;

    public Ruang() {
    }

    public Ruang(String kode, String nama,
                 int kapasitas, int gedungId) {
        this.kode = kode;
        this.nama = nama;
        this.kapasitas = kapasitas;
        this.gedungId = gedungId;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public int getGedungId() {
        return gedungId;
    }

    public void setGedungId(int gedungId) {
        this.gedungId = gedungId;
    }

    @Override
    public void validasi() throws ValidationException {

        if (kode == null || kode.trim().isEmpty()) {
            throw new ValidationException(
                    "Kode", "tidak boleh kosong");
        }

        if (nama == null || nama.trim().isEmpty()) {
            throw new ValidationException(
                    "Nama", "tidak boleh kosong");
        }

        if (kapasitas <= 0) {
            throw new ValidationException(
                    "Kapasitas", "harus lebih dari 0");
        }

        if (gedungId <= 0) {
            throw new ValidationException(
                    "Gedung", "harus dipilih");
        }
    }

    @Override
    public String label() {
        return nama + " (" + kode + ")";
    }
}
