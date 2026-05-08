# GrowGame APK

Proyek Android minimal ini adalah game 2D sederhana yang meniru konsep Growtopia: dunia blok, avatar, dan aksi pasang/hancurkan blok.

## Fitur

- dunia tile grid 20x14
- blok tanah, rumput, dan batu
- kontrol tombol onscreen: kiri, kanan, atas, bawah, pasang, hancurkan
- tampilan sederhana yang bisa dikembangkan menjadi gameplay lebih besar

## Struktur

- `app/src/main/java/com/gtorro/growgame/MainActivity.kt`
- `app/src/main/java/com/gtorro/growgame/GameView.kt`
- `app/src/main/res/layout/activity_main.xml`
- `app/build.gradle.kts`
- `build.gradle.kts`
- `settings.gradle.kts`

## Build

Android SDK diperlukan untuk membangun APK.

1. Set `ANDROID_SDK_ROOT` atau buat `local.properties` di root proyek dengan:
   ```text
   sdk.dir=/path/to/android/sdk
   ```
2. Jalankan:
   ```bash
   ./gradlew assembleDebug
   ```

APK akan muncul di `app/build/outputs/apk/debug/app-debug.apk` setelah build berhasil.

## GitHub Actions

Jika kamu tidak punya laptop, build APK bisa dilakukan otomatis lewat GitHub Actions.

Cukup push repo ini ke GitHub dan workflow berikut akan berjalan:
- `.github/workflows/android-build.yml`

Hasil build dapat diunduh dari artifact `app-debug-apk` di halaman Actions.
