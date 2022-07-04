package view;

import Connected.Connect;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MhsDaoImp implements MhsDao {

    Connect k = new Connect();
    String[] kolom = {"NIM", "NAMA", "JURUSAN", "JENIS KELAMIN"};

    private String read = "SELECT*FROM tbl_mahasiswa";
    private String create = "INSERT INTO tbl_mahasiswa (nim, nama, jenis_kelamin, jurusan) VALUES (?, ?, ?, ?)";

    private PreparedStatement ps;

    @Override
    public void read(JTable jt) {

        try {
            DefaultTableModel dtm = new DefaultTableModel(null, kolom);
            Statement s = k.getCon().createStatement();
            ResultSet rs = s.executeQuery("SELECT*FROM tbl_mahasiswa");

            while (rs.next()) {
                Object[] ob = new Object[4];
                ob[0] = rs.getString("nim");
                ob[1] = rs.getString("nama");
                ob[2] = rs.getString("jurusan");
                ob[3] = rs.getString("jenis_kelamin");
                dtm.addRow(ob);
            }
            jt.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(MhsDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Mhs m) {   // menambahkan data ke database
        try {
            ps = k.getCon().prepareStatement(create);
            ps.setString(1, m.getNim());
            ps.setString(2, m.getNama());
            ps.setString(3, m.getJk());
            ps.setString(4, m.getJurusan());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Berhasil Disimpan");
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err);
        }
    }

    @Override
    public void update(Mhs m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void search(JTable jt, Mhs m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
