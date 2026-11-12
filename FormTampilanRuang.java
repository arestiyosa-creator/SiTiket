package latihan;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class FormTampilanRuang extends JFrame {
    private JTextField fKode;
    private JTextField fNama;
    private JTextField fKapasitas;
    private JTextField fGedung;

    public FormTampilanRuang() {
        super("Data Ruang");
        setSize(760, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        susunKomponen();
    }

    private void susunKomponen() {
        setLayout(new BorderLayout(8,8));

        JPanel panelAtas = new JPanel();
        panelAtas.add(new JLabel("Nama:"));
        panelAtas.add(new JTextField(20));
        panelAtas.add(new JButton("Cari"));
        add(panelAtas, BorderLayout.NORTH);

        String[] judulKolom = {"Kode", "Nama", "Kapasitas", "Gedung"};
        Object[][] dataSementara = {
                {"R-101", "Ruang Kuliah A101", "40", "Gedung A"},
                {"R-102", "Ruang Kuliah A102", "36", "Gedung A"},
                {"R-201", "Laboratorium Komputer", "30", "Gedung B"}
        };
        JTable table = new JTable(dataSementara,judulKolom);
        add(new JScrollPane(table), BorderLayout.CENTER);

        fKode = new JTextField(14);
        fNama = new JTextField(14);
        fKapasitas = new JTextField(14);
        fGedung = new JTextField(14);
        JTextField[] isian = {fKode,fNama,fKapasitas,fGedung};
        add(buatPanelIsian(
                new String[]{"Kode", "Nama", "Kapasitas", "Gedung"}, isian), BorderLayout.EAST);

        JPanel panelBawah = new JPanel();
        panelBawah.add(new JButton("Baru"));
        panelBawah.add(new JButton("Simpan"));
        panelBawah.add(new JButton("Hapus"));
        add(panelBawah, BorderLayout.SOUTH);
    }

    private JPanel buatPanelIsian(String[] judul, JTextField[] isian) {
        JPanel kolomLabel = new JPanel(new GridLayout(judul.length, 1,6,6));
        JPanel kolomIsian = new JPanel(new GridLayout(judul.length, 1,6,6));
        for (int i= 0;i < judul.length; i++){
            kolomLabel.add(new JLabel(judul[i]));
            kolomIsian.add(isian[i]);
        }
        JPanel panel = new JPanel(new BorderLayout(6,0));
        panel.setBorder(BorderFactory.createTitledBorder("Isian"));
        panel.add(kolomLabel, BorderLayout.WEST);
        panel.add(kolomIsian, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormTampilanRuang().setVisible(true));
    }
}

