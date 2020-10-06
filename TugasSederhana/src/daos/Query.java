/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

/**
 *
 * @author Ardian
 */
public enum Query {
    QUERY_INSERT_TRANSACTION("insert into transaksi (ID_Trans, Jenis, Nominal, Tanggal, Rekening_tujuan, ID_user) values (?, ?, ?, ?, ?, ?)"),
    QUERY_UPDATE_INCREMENT("update akun_bank set `Saldo` = (? + ?) where `Nama` = ?"),
    QUERY_CHECK_BALANCE("select Saldo from akun_bank where `Nama` = ?"),
    QUERY_USERID("select ID_user from akun_bank where `Nama` = ?"),
    QUERY_TRANSACTIONID("select ID_trans from transaksi order by ID_trans desc"),
    QUERY_COUNT_ROW("select COUNT(*) FROM transaksi"),
    QUERY_CHECK_BALANCE_DEST("select Saldo from akun_bank where `Rekening` = ?"),
    QUERY_USERID_RECEIVER("select ID_user from akun_bank where `Rekening` = ?"),
    QUERY_DELETE_DATA("delete from transaksi"),
    QUERY_UPDATE_DECREMENT("update akun_bank set `Saldo` = (? - ?) where `Nama` = ?"),
    QUERY_UPDATE_DEST("update akun_bank set `Saldo` = (? + ?) where `Rekening` = ?"),
    QUERY_HISTORY("SELECT * FROM `transaksi` WHERE ID_user = ?"),
    QUERY_ACCOUNT("SELECT * FROM akun_bank"),
    QUERY_INSERT_ACCOUNT(" INSERT INTO akun_bank (ID_user, Nama, Rekening, Nomor_Kartu, PIN, Saldo, ID) values (?, ?, ?, ?, ?, ?, ?)"),
    QUERY_INSERT_USER("INSERT INTO pengguna(ID, Nama, Telfon, email, ID_user) VALUES (?, ?, ?, ?, ?)"),
    QUERY_LIHAT_SALDO("select * from akun_bank WHERE Nama = ?");

    private final String displayName;

    Query(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    //enkripsi pakai bcrypt
}
