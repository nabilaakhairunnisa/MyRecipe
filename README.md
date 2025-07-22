# Proyek Resep KMM

Aplikasi resep sederhana yang dibangun menggunakan Kotlin Multiplatform Mobile (KMM) dan Jetpack Compose. Aplikasi ini menampilkan daftar resep dan detailnya, termasuk bahan-bahan dan cara memasak.

Aplikasi ini dibangun menggunakan template resmi dari Kotlin sebagai demonstrasi dan sarana pembelajaran tentang pengembangan aplikasi lintas platform menggunakan teknologi Kotlin. 
**Sumber Template:** [Kotlin/KMP-App-Template](https://github.com/Kotlin/KMP-App-Template)

## Fitur

* **Tampilan Daftar Resep:** Menampilkan daftar resep yang tersedia. 
* **Tampilan Detail Resep:** Menampilkan detail resep, termasuk:
    * Gambar resep
    * Judul resep
    * Daftar bahan-bahan
    * Langkah-langkah cara memasak
* **Navigasi:** Pengguna dapat kembali dari layar detail ke layar sebelumnya.
* **Loading State:** Menampilkan konten kosong saat data sedang dimuat atau tidak tersedia.
* **Pengambilan Data Asinkron:** Menggunakan `collectAsStateWithLifecycle` untuk mengambil data resep secara asinkron.
* **Dependency Injection:** Menggunakan Koin untuk dependency injection.
* **Image Loading:** Menggunakan Coil 3 untuk memuat gambar dari URL.
* **UI Modern:** Dibangun dengan Jetpack Compose untuk antarmuka pengguna.

## Teknologi yang Digunakan

* **Kotlin Multiplatform Mobile (KMM):** Untuk berbagi logika bisnis antara Android dan iOS.
* **Jetpack Compose:** Untuk membangun UI native di Android.
* **Kotlin Coroutines:** Untuk pemrograman asinkron.
* **Koin:** Untuk dependency injection.
* **Coil 3:** Untuk memuat gambar.
* **Material 3:** Komponen UI modern dari Google.

<img src="https://github.com/nabilaakhairunnisa/myrecipe/blob/master/ss1.png"
     alt="Main Activity"
     style="float: left; margin-right: 10px;"
     width="2000" />

<img src="https://github.com/nabilaakhairunnisa/myrecipe/blob/master/ss2.png"
     alt="Main Activity"
     style="float: left; margin-right: 10px;"
     width="2000" />

