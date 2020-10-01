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
