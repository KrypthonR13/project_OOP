package view;

import javax.swing.JTable;

public interface MhsDao {
    
    public void read(JTable jt); //nampilkan data table
    
    public void create(Mhs m); //menambahkan data
    
    public void update(Mhs m); // ubah data
    
    public void delete(int id); // hapus data
    
    public void search(JTable jt, Mhs m); //pencarian data
    
}
