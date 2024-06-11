package com.ricomuh.perpustakaan;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aplikasi Perpustakaan");

        TabPane tabPane = new TabPane();

        // Tab Buku
        Tab tabBuku = new Tab("Buku", createBukuTab());
        tabPane.getTabs().add(tabBuku);

        // Tab Pustakawan
        Tab tabPustakawan = new Tab("Pustakawan", createPustakawanTab());
        tabPane.getTabs().add(tabPustakawan);

        // Tab Anggota
        Tab tabAnggota = new Tab("Anggota", createAnggotaTab());
        tabPane.getTabs().add(tabAnggota);

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createBukuTab() {
        TableView<Buku> table = new TableView<>();
        TableColumn<Buku, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Buku, String> judulCol = new TableColumn<>("Judul");
        judulCol.setCellValueFactory(new PropertyValueFactory<>("judul"));

        TableColumn<Buku, String> penulisCol = new TableColumn<>("Penulis");
        penulisCol.setCellValueFactory(new PropertyValueFactory<>("penulis"));

        TableColumn<Buku, Integer> tahunTerbitCol = new TableColumn<>("Tahun Terbit");
        tahunTerbitCol.setCellValueFactory(new PropertyValueFactory<>("tahunTerbit"));

        table.getColumns().add(idCol);
        table.getColumns().add(judulCol);
        table.getColumns().add(penulisCol);
        table.getColumns().add(tahunTerbitCol);

        Button addButton = new Button("Tambah Buku");
        Button updateButton = new Button("Update Buku");
        Button deleteButton = new Button("Hapus Buku");

        // Tambahkan aksi ke tombol-tombol ini untuk memanggil metode DAO yang sesuai

        VBox vbox = new VBox(table, addButton, updateButton, deleteButton);
        return vbox;
    }

    private VBox createPustakawanTab() {
        TableView<Pustakawan> table = new TableView<>();
        TableColumn<Pustakawan, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Pustakawan, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));

        TableColumn<Pustakawan, String> alamatCol = new TableColumn<>("Alamat");
        alamatCol.setCellValueFactory(new PropertyValueFactory<>("alamat"));

        TableColumn<Pustakawan, String> teleponCol = new TableColumn<>("Telepon");
        teleponCol.setCellValueFactory(new PropertyValueFactory<>("telepon"));

        table.getColumns().add(idCol);
        table.getColumns().add(namaCol);
        table.getColumns().add(alamatCol);
        table.getColumns().add(teleponCol);

        Button addButton = new Button("Tambah Pustakawan");
        Button updateButton = new Button("Update Pustakawan");
        Button deleteButton = new Button("Hapus Pustakawan");

        // Tambahkan aksi ke tombol-tombol ini untuk memanggil metode DAO yang sesuai

        VBox vbox = new VBox(table, addButton, updateButton, deleteButton);
        return vbox;
    }

    private VBox createAnggotaTab() {
        TableView<Anggota> table = new TableView<>();
        TableColumn<Anggota, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Anggota, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));

        TableColumn<Anggota, String> alamatCol = new TableColumn<>("Alamat");
        alamatCol.setCellValueFactory(new PropertyValueFactory<>("alamat"));

        TableColumn<Anggota, String> teleponCol = new TableColumn<>("Telepon");
        teleponCol.setCellValueFactory(new PropertyValueFactory<>("telepon"));

        table.getColumns().add(idCol);
        table.getColumns().add(namaCol);
        table.getColumns().add(alamatCol);
        table.getColumns().add(teleponCol);

        Button addButton = new Button("Tambah Anggota");
        Button updateButton = new Button("Update Anggota");
        Button deleteButton = new Button("Hapus Anggota");

        // Tambahkan aksi ke tombol-tombol ini untuk memanggil metode DAO yang sesuai

        VBox vbox = new VBox(table, addButton, updateButton, deleteButton);
        return vbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
