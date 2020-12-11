# Tutorial APAP
## Authors
* **Muhammad Ramy Azhar** - *1806191446* - *A*
## Tutorial 1

### What I have learned today

### Github
1. Apa itu Issue Tracker? 
 issue tracker adalah suatu fitur di github yang mana membantu kita untuk mencatat, atau membuat issue baru jika terjadi masalah. Dengan begitu, masalah atau permintaan perubahan dapat di-track dengan mudah.
 Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
 dengan issue tracker kita bisa menyelesaikan masalah untuk bug(jika ada bug/kesalahan dalam program kita),documentation(menambah dokumentasi pada program),duplicate(jika terdapat pull request yang duplikat),enhancement(jika ingin menambah fitur pada program/apps), good first issue(untuk dikerjakan oleh orang baru), help wanted(penting dan butuh bantuan secepatnya), invalid(terlihat ada yang tidak beres),questtion(jika membutuhkan informasi selanjutnya lebih lanjut), wontflix(jika program tidak akan bekerja), dan masih banyak issue/masalah yang lain jika dibutuhkan tergantung kebutuhan tim pengembang.

2. Apa perbedaan dari git merge dan git merge --squash?
setahu saya keduanya memiliki tujuan yang sama, yaitu menggabungkan branch dengan master-nya, namun perbedaannya git merge menggabungkan bersama semua commit-commit yang ada atau yang telah terjadi , namun git merge --squash menggabungkan branch dengan master-nya tapi mereplace semua commit-commitnya menjadi hanya 1 commit saja. 

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu
aplikasi?
dengan menggunakan version control system seperti git dalam pengembangan suatu aplikasi, banyak sekali benefit yang bisa dipakai, contohnya adalah branching dan merging yang bisa membantu kita untuk mengembangkan satu fitur baru pada suatu produk tanpa harus mengganggu fitur utama yang berjalan (mengembangkan secara paralel), jika diakhir banching tidak ada masalah dan siap dipakai, maka branch tersebut bisa di merge dan akan menyatu dengan fitur utamanya. selain itu juga traceability, dengan VCS kita bisa men-tracing sekiranya pekerjaan apa saja yang sudah collaborator lainnya lakukan, dan jika didepan ada masalah atau ada hal yang tidak diinginkan, bisa di revert , kembali program sebelum push tersebut dilakukan.

### Spring
4. Apa itu library & dependency?
library adalah koleksi dari fungsi yang bisa dipakai di suatu aplikasi(jika dibutuhkan) dan fungsi fungsi tersebut siap digunakan dan dimanfaatkan oleh aplikasi-aplikasi lain.
dependency adalah keterkaitan, biasanya keterkaitan antar fungsi atau antar kelas, dan sebaiknya antar kelas atau antar fungsi memiliki ketergantungan yang minim, sehingga jika 1 kelas/fungsi berubah maka tidak perlu mengkhawatirkan yang lain.

5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
maven adalah suatu tool untuk project managemnt berdasarkan POM(project object model), maven bisa digunakan untuk mengembangkan dan memanajemen java-based project. dengan menggunakan maven, kita juga bisa dengan mudah mengintegrasikan project kita dengan source control system seperti subversion atau git. alternatif dari Maven adalah antaralain seperti Gradle, Sonatype Nexus, CMake, dll.

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
selain dalam pengembangan web, spring framework juga bisa digunakan untuk pengembangan aplikasi android, REST apis, Caching, dan masih banyak lagi.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
sebenarnya keduanya bisa digunakan untung meng-extract value dari request URI, namun terdapat perbedaan yaitu, @RequestParams meng-extract values dari query string(di encode), sedangkan  @PathVariables meng-extract values dari URI path(tidak di encode).sehingga untuk @RequestParam lebih cocok untuk aplikasi web yang tradisional dimana data disimpan melalui query. sedangkan @PathVariable  berguna untuk aplikasi web yang menyimpan dan mengakses data dari URL dengan values tanpa query.




### What I did not understand

-[v]bagaimana implementasi maven sebenarnya dalam pengembangan proyek?
-[v]apakah ada cara untuk mengextract data dari request uri selain @RequestParam / @PathVariable?


## Tutorial 2

### What I have learned today
dari tutorial ini saya menjadi lebih mengerti tentang service , model, dan controller.  Selain itu, saya juga belajar berbagai cara untuk mengambil data dari URL (path variable dan request param) dan saya juga belajar membuat method-method untuk add, update dan delete objek dengan menggunakan request mapping.

### Pertanyaan
1. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom
&noTelepon=081xxx
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi?
yang terjadi adalah error, karena saat membuka link tersebut, akan diarahkan kepada add-hotel.html , dimana saat pertanyaan ini ditanyakan si add-hotel.html ini belum dibuat.
kalo udah dibuat add-hotel.html nya, nanti ga error.

2.  Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan
implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam
konteks service dan controller yang telah kamu buat
autowired pada class controller tersebut merupakan implementasi dari konsen dependency injection. 
cara kerjanya adalah dependency interfacenya diinject otomatis via autowiring ke service yang mengimplementasi autowiring ini.


3. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
ERROR! , karena dari link yang diberikan parameternya gak lengkap, kurang parameter nomer telepon, karena atribut nomor telepon pada request param nya bernilai true, jadi mesti ada nomer teleponnya, tapi di link nya gada nomor teleponnya, jadinya kekurangan parameter, menyebabkan error.

4. Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus
diakses?
karena tadi kita mencoba membuat hotel papa APAP dengan idHotel = 1 .  maka tinggal mencari dengan akses link 
http://localhost:8080/hotel/view/id-hotel/1

5. Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses
http://localhost:8080/hotel/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
saya tadi mencoba menambahkan lebih dari 1 hotel, alhasil tampilan dari http://localhost:8080/hotel/viewall adalah seluruh hotel yang sebelumnya saya tambahkan. berikut screenshoot nya https://ibb.co/R9PRBx8 


### What I did not understand

---
## Tutorial 3

### What I have learned today
Pada tutorial-3 ini,  saya belajar tentang model, service dan controller. Selain itu, saya juga belajar membuat method-method untuk add, update dan delete obyek dengan menggunakan request mapping. saya juga belajar untuk membuat database menggunakan phpmysql, setelah membuat saya juga belajar untuk menghubungkan database-database terkait dan mengatur behavior dan relasinya. saya juga belajar menggunakan kondisional dalam HTML. yang paling seru adalah belajar menggunakan JPA repository, yang mana sangat membantu dalam mengakses data atau mengambil data. Lab ini sedikit mirip dengan lab 2 namun lebih menantang dan lebih banyak menemukan error.

### PERTANYAAN
1. **Pada class KamarDb, terdapat method findAllByHotelId, apakah kegunaan dari method tersebut?**
Method findAllByHotelId berguna untuk mengambil kamar berdasarkan id hotel yang berasal dari hotel model dan akan dimasukan ke dalam sebuah list. Pengambilan data dilakukan dengan cara melakukan query ke database SQL. Method findBy itu sendiri merupakan bawaan dari JPA Repository yang berguna untuk mempermudah programmer dalam melakukan pengambilan data tanpa membuat querynya terlebih dahulu.

2. **Pada class HotelController, jelaskan perbedaan method addHotelFormPage dan addHotelSubmit?**
method addHotelFormPage menggunakan Request Method GET. GET digunakan untuk mendapatkan suatu data dari database. Fungsi dari addHotelFormPage adalah untuk mendapatkan restoran mana yang mau di ubah datanya. addHotelSubmit menggunakan Request Method POST. POST digunakan untuk mengubah suatu data pada database. Fungsi dari addHotelSubmit adalah untuk mengubah dan mensubmit perubahan yang dilakukan.

3. **Jelaskan kegunaan dari JPA Repository!**
JPA Repository adalah sebuah Object Relational Mapping (ORM) dari java spring. JPA Repository berguna untuk mempermudah programmer dalam mengakses data atau mengambil data karena JPA repository menyediakan segala fungsional tanpa harus membuat query.selain itu kegunaan dari JPA Repository adalah untuk menghubungkan database (mysql) dengan model. ORM juga berguna untuk melindungi dari serangan seperti SQL Injection.

4. **Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat?**
- Bagian pada HotelModel yaitu
   @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
   private List<KamarModel> listKamar; 
- Bagian pada KamarModel yaitu:
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "hotelId", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private HotelModel hotel;
- Kedua kode tersebut akan menghubungkan relasi yang terjadi antara HotelModel dengan KamarModel. @OneToMany pada HotelModel menandakan bahwa setiap hotel dapat memiliki lebih dari satu kamar. @JoinColumn pada KamarHotel akan memiliki tambahan atribut yaitu hotelId yang me-referenced id dari HotelModel. mappedBy dengan value hotel menandakan hotel menjadi refrensi terhadap kamar.

5. **Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER!**
- FetchType.LAZY merupakan salah satu tipe Hibernate yang tidak melakukan load untuk semua collection object child saat object parent di-fetch. Collection object child hanya di-load jika secara eksplisit dibutuhkan via getter method. Default fetching tipe ini adalah OnetoMany dan ManytoMany. 

- CascadeType.ALL merupakan salah satu tipe Hibernate juga yang menyediakan property cascade pada hubungan OnetoMany untuk memudahkan kita dalam melakukan operasi database. Semua obyek yang berelasi dengan entitas yang dihapus juga akan ikut terhapus (seolah-olah entitas tersebut tidak pernah ada).

- FetchType.EAGER merupakan salah satu tipe Hibernate, mendapat semua data dari suatu obyek/tabel termasuk data dari tabel yang berelasi dengan obyek/tabel Default fetching tipe ini adalah OnetoMany dan ManytoMany. Contoh implementasinya pada tutorial 3 ini adalah saat kita ingin melihat keseluruhan hotel, dimana pastinya akan secara bersamaan datanya semuanya diakses.

### What I did not understand

---
## Tutorial 4

### What I have learned today
Pada tutorial-4 ini,  saya belajar lebih lanjut mengenai thymeleaf, saya belajar untuk bisa mengefisienkan penggunaan navbar dengan fragments. saya juga belajar cara menghias web lebih baik seperti saat mata kuliah ppw. saat membuat navbar juga saya belajar agar bisa membuat navbar tersebut menjadi dinamis. lab ini lebih seru daripada lab sebelumnya karena apa yang kita coding bisa langsung terlihat nyata dan menyenangkan. 

### PERTANYAAN
1. **Jelaskan perbedaan th:include dan th:replace!**
th:include berati akan memasukkan konten yang ada di fragments kedalam tag hostnya.sedangkan th:replace berfungsi untuk mengganti tag host dengan fragmen yang berarti menghapus tag host dan sebagai pengganti tag host, itu akan menambahkan fragmen yang ditentukan termasuk tag fragmen.

2. **Jelaskan apa fungsi dari th:object!**
th:object digunakan untuk submit pada form sehingga mengetahui object apa yang di submit. Th:object juga digunakan untuk menentukan object mana yang akan diisi.

3. **Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?**
 *= akan mengevaluasi atribut atau varible dari th:object yang sudah di deklarasi sebelumnya
 $= akan mengevaluasi keseluruhan atribut atau variabel pada th:object

4. **Bagaimana kamu menyelesaikan latihan nomor 3?**
yang saya pelajari adalah Fragment dapat bersifat dynamic. Cara saya menyelesaikan nomor 3 adalah dengan menambahkan

th:text="${brand}"

yang bertujuan untuk menulis title navbar nya. Brand sendiri value nya di set dan di ambil dari html terkait.

### What I did not understand

---
## Tutorial 5

### What I have learned today
Pada tutorial-5 ini, saya belajar lebih lanjut mengenai webservice, saya belajar untuk bisamenggunakan restservice dan restcontroler. saya juga belajar cara menggunakan API dari suatu web.

### PERTANYAAN
1. **Apa itu Postman? Apa kegunaannya?**
- Postman merupakan sebuah aplikasi (plugin) untuk browser chrome sebagai REST Client. Aplikasi ini berguna untuk melakukan uji coba REST API yang telah dibuat.
- tool Postman merupakan salahsatu tool wajib yang digunakan developer yang berkutat pada pembuatan API sebab fungsi utamanya adalah sebagai GUI API Caller. Namun sekarang postman juga menyadiakan fitur lain seperti Sharing Collection API for Documentation (free), Testing API (free), Realtime Collaboration Team (paid), Monitoring API (paid), Integration (paid).
2. **Apa kegunaan dari annotation @JsonIgnoreProperties dan @JsonProperty?**
- @JsonIgnoreProperties digunakan untuk menekan serialisasi properti atau mengabaikan pemrosesan properti JSON yang dibaca saat deserialisasi.eserialization JSON. Hal ini dapat memudahkan kita untuk panggilan REST dan menghasilkan objek domain. 
- @JsonProperty is used to map property names with JSON keys during serialization and deserialization. By default, if you try to serialize a POJO, the generated JSON will have keys mapped to the fields of the POJO. If you want to override this behavior, you can use the @JsonProperty annotation on the fields.
3. **Apa kegunaan attribut WebClient?**
- webclient digunakan untuk restserviceimpl yang digunakan untuk mengirim serta menerima data dari resource URI. akses diberikan pada webrequest class/
4. **Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?**
- ResponseEntity berguna untuk mewakili seluruh respons HTTP dan berguna untuk mengikonfigurasi response HTTP secara keseluruhan. 
- BindingResult biasanya berisikan informasi mengenai kesalahan, misalkan field yang diperlukan, adanya ketidakcocokan jenis atau kesalahan dalam melakukan pemanggilan method.

### What I did not understand


---
## Tutorial 6

### What I have learned today
Pada tutorial-6 ini saya belajar bagaimana cara membuat user, dengan username dan pasword, saya juga belajar bagaimana memberi akses spesial kepada role-role tertentu.

### PERTANYAAN
1. **Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?** 

- Otentikasi verifikasi apakah seseorang itu adalah proses memeriksa detail pengguna untuk mengidentifikasinya dan memberikan akses ke sistem. Biasanya melibatkan username dan password. Sedangkan otorisasi adalah proses memeriksa hak atau izin pengguna yang diotentikasi untuk mengakses sistem bagian spesifik.
- Berikut merupakan contoh implementasi otentifikasi pada class `WebSecurityConfig`:
@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{auth.userDetailsService(userDetailsService).passwordEncode(encoder());}

- Berikut merupakan contoh implementasi otorisasi pada class `WebSecurityConfig`:
.authorizeRequests()
.antMatchers("/css/**").permitAll()
.antMatchers("/js/**").permitAll()
.antMatchers("/hotel/**").hasAuthority("RECEPTIONIST")
.antMatchers("/user/addUser").hasAuthority("ADMIN")
.antMatchers("/kamar/add/**").hasAuthority("RECEPTIONIST")
2. **Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!**
- BCryptPasswordEncoder adalah fungsi hashing untuk mengenkripsi sehingga password tidak diketahui walaupun sudah dilihat di databse. BCryptPasswordEncoder meng encrypt String Raw menjadi String yang sudah di acak agar tidak mudah diketahui.
3. **Jelaskan secara singkat apa itu UUID beserta penggunaannya!** 
- universally unique identifier (UUID) adalah digunakan untuk mengidentifikasi secara unik beberapa objek atau entitas di Internet. Bergantung pada mekanisme spesifik yang digunakan, UUID dijamin berbeda atau, paling tidak, sangat mungkin berbeda dari UUID lain yang ada. UUID digunakan untuk meningkatkan keamanan data pengguna dikarenakan id pengguna akan digenerate secara unik dengan hashing sebanyak 32 karakter secara acak sehingga id pengguna aman dan tidak mudah untuk diretas. 
4. **Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?**
- UserDetailsService adalah antarmuka inti dalam kerangka kerja Spring Security, yang digunakan untuk mengambil informasi otentikasi dan otorisasi pengguna. Ini memiliki metode baca-saja tunggal bernama loadUserByUsername() yang mencari pengguna berdasarkan nama pengguna.

---

## Tutorial 7
### Pertanyaan
**1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi
dari apa yang Anda jelaskan.**  

###### Soal 1
Hilangkan checkbox pada item di list bagian kiri. Bagian dari code yang menampilkan button adalah component Item.js. Pada nomor ini saya menggunakan conditional di Item.js. checked adalah variable yang menjadi pembeda dari favorite items dan menu. Sehingga saya menggunakan conditional pada Item.js seperti berikut.
https://ibb.co/mDydCKB

###### Soal 2
Pada kali ini saya membuat sebuah button yang mampu menghapus seluruh isi list favorite dengan cara membuat sebuah 
fungsi di app.js yang mengubah state dari favItems menjadi kosong. Code yang saya buat adalah:
  deleteItemClick = () => {
    this.setState({favItems: []});
  }
Selanjutnya saya membuat button yang memanggil fungsi ini. Code yang dibuat adalah:
<button onClick={this.deleteItemClick}>Delete</button>
Untuk Tombol hanya akan muncul apabila sudah ada item di dalam list favorites, dapat dilihat source code nya pada bagian
nomor 5 dengan cara *Ternary Display*. Hasil dari kode yang sudah dibuat adalah:
- Sebelum dihapus
![image](https://user-images.githubusercontent.com/60350747/101043904-5ff04f00-35b1-11eb-8c06-b2bfa9e48a9d.png)
- Sesudah dihapus
![image](https://user-images.githubusercontent.com/60350747/101043971-73031f00-35b1-11eb-997c-6ccf3e4578fe.png)
https://ibb.co/MMPgsct

###### Soal 3
Buatlah mekanisme agar bagian kiri hanya melakukan operasi add Operasi yang membuat item di remove dari favorites items adalah "newItems.splice(targetInd, 1);". sehingga untuk bagian kiri, saya membuat fungsi tanpa "newItems.splice(targetInd, 1);". Sekarang yang kiri hanya dapat melakukan operasi add. Lalu fungsi nya dipanggil pada html sesuai kebutuhan dengan onClick.
https://ibb.co/X8PSk7w

###### Soal 4
Buatlah toggle dimana jika toggle ON, maka My Favorite ditampilkan. Pertama saya membuat toggle di App.js yang memanggil fungsi hideFavorite saat onClick. Saya juga memuat boolean hideFav yang berarti favorite disembunyikan atau tidak. Setelah itu, saya membuat fungsi yang mengubah nilai dari hideFav sehingga mengubah disembunyikan atau tidak. Selain itu, saya juga menambahkan "this.setState({ });" untuk memberi tahu React bahwa komponen ini perlu dirender ulang dengan state yang diperbarui. Setelah itu, pada render return nya, saya menambahkna conditional apakah hideFav true atau false untuk memilih ditampilkannya favorites atau apa tidak.
https://ibb.co/StFZcz8

###### Soal 5
ika daftar favorit kosong, maka tampilkan empty state. Saya membuat component baru yaitu EmptyState yang berisi seperti html yang memberi tahu favorite kosong (seperti di gambar). Jika favorite items kosong artinya panjang array dari favItems akan 0. maka saya menambahkan conditional yang mengecek apakah favItems.length = 0, jika iya akan menampilkan EmptyState.
https://ibb.co/DgxHBzK

**2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?**  
Menurut saya, state adalah sebuah data private dari sebuah component yang hanya bisa tersedia untuk component tersebut
tanpa bisa diakses dari component lain. Sedangkankan props adalah singkatan dari property yang merupakan sebuah
parameter dari fungsi component. Bentuk props sangat mirip seperti attribute pada tag HTML. Sumber: https://medium.com/coderupa/react-prop-state-apa-bedanya-7ee61df8257f  

**3. Apa keuntungan menggunakan component (e.g. List, Item) di React? Berikan contohnya!**  
Keuntungan menggunakan component di React adalah kita bisa membuat suatu code yang bisa direuse berkali-kali sesuai dengan
kebutuhan dan kita tinggal panggil saja misalnya di bagian App.js. Contohnya adalah pada tutorial kali ini dimana ada
component List dan Item yang bisa dipanggil ulang untuk menampilkan seluruh film yang ada di file json sekaligus menampilkan
seluruh hasil favorit. Kode ini bisa kita panggil berkali-kali sesuai denga kebutuhan kita.  

**4. Menurut kamu, apa saja kelebihan menggunakan React dalam pengembangan web?**  
Kelebihan dalam menggunakan React adalah komponen yang dapat digunakan kembali seperti dari nomor 3, membuat aplikasi web
dinamis menjadi lebih mudah dikarenakan React dibuat menggunakan Javascript yang terkenal dengan animasi serta desain yang
baik dalam website, dan mampu memanfaatkan Javascript Library untuk diimplementasikan ke dalam website.  

**5. Menurut kamu, apa saja kekurangan menggunakan React dalam pengembangan web?**  
Kekurangan dari React dalam pengembangan web adalah hanya mendukung website yang baru-baru saja seperti Google Chrome
dan Mozila Firefox. Untuk browser lama, tidak akan bisa disupport oleh React. Selanjutnya juga dokumentasi dari ReactJS
kurang lengkap dan sistematis sehingga bagi seorang developer yang baru belajar (terutama saya yang tidak suka Javascript) 
cukup sulit untuk fasih menggunakan ReactJs.


---

## Tutorial 8
### Pertanyaan
**1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?.**
setelah melakukan this.loadData() , saya mengosongkan statenya kembali dengan cara
      this.setState({
        namaHotel: "",
        alamat: "",
        nomorTelepon: "",
      })
agar ketika membuka modalnya, fieldnya sudah kososng



**2. Jelaskan fungsi dari async dan await!**  
Menurut saya, await digunakan untuk menunggu Janji. Ini dapat digunakan di dalam blok Async saja. await membuat JavaScript menunggu sampai hasil dikembalikan. Perlu dicatat bahwa itu hanya membuat blok fungsi async menunggu dan bukan keseluruhan eksekusi program.

**3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 7 pada Component Lifecycle pada pertanyaan ini.**  

https://docs.google.com/document/d/184jgkFoui_V-0PgQP838LTGrxoxU4957BQxV2Wa61L4/edit?usp=sharing  

**4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate componentWillReceiveProps, componentWillUnmount.**  


componentDidMount, fungsi dipanggil ketika komponen selesai dibuat, usecase yang biasa menggunakannya adalah ketika ingin mengetahui suatu komponen selesai dibuat.
shouldComponentUpdate, fungsi dipanggil ketika property atau state dari komponen telah berubah , usecase yang biasa menggunakannya adalah ketika ingin mengetahui perubahan porps/state dari komponen terkait
componentDidUpdate , fungsi dipanggil ketika sebelum atatu sesudah komponen di render kembali , usecase yang biasa menggunakannya adalah ketika ada pekerjaan manual dari luar react yang mengupdate si component
componentWillReceiveProps, fungsi dipanggil ketika dipanggil sebelum komponen menerima props yang nilainya telah berubah , usecase yang biasa menggunakannya adalah ketika mengubah si component
componentWillUnmount, fungsi dipanggil ketika ingin menghancurkan/menghapus/menyingkirkan komponen , usecase yang biasa menggunakannya adalah ketika ingin unsubscribe