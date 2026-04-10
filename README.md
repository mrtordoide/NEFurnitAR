# NEFurnitAR

Android furniture storefront where users can browse a live catalog, manage a cart, and preview supported products in augmented reality on ARCore-capable devices.

## What it does

- **Catalog** — Products load from **Cloud Firestore** (`items` collection).
- **Browse & filter** — Toggle “AR-capable” vs non-AR items, filter by category (`chair`, `sofa`, `wardrobe`, `bed`, `cabinet` via a `cat` field), and search by product name (prefix range query).
- **Product detail** — Shows name, price, description, and images (Picasso). **View in AR** is available when `isAR` is true and ARCore reports the device as supported; the AR screen loads a **glTF 2.0** model from the URL stored as the **second** entry in the item’s `images` list (the first entry is the gallery image).
- **Account** — **Firebase Authentication** with email/password and **Google Sign-In**.
- **Cart & checkout** — Local **SQLite** cart (`Database` / `sqliteassethelper`) stays in sync with Firestore `cart`. Completing a purchase updates `items`, writes **`purchase_history`**, clears cart lines in Firestore.
- **Monetization & analytics** — **Google Mobile Ads** (banner) and **Firebase Analytics** events on key actions.

## Tech stack

| Area | Choice |
|------|--------|
| Language | Java |
| UI | Android Support Library 28, Material Design components, RecyclerView, navigation drawer (MaterialDrawer) |
| Backend | Firebase Auth, **Firestore** (not Realtime Database in the active code paths) |
| Local data | SQLite (prebuilt `cartDB.db` asset) |
| AR | **ARCore** + **Sceneform** 1.6.x — remote GLTF2 via `RenderableSource` |
| Images | Picasso |
| Other | ButterKnife, Play Services Auth |

## Requirements

- **Android Studio** compatible with Gradle **6.1.1** and Android Gradle Plugin **4.0.0**.
- **minSdkVersion** 22, **compile/targetSdkVersion** 28 (`app/build.gradle`).
- A valid **`app/google-services.json`** from Firebase project.
- For AR: device with **ARCore**, **Android N (API 24)+**, and **OpenGL ES 3.0+** (enforced in `ARactivity`).

## Build

```bash
./gradlew assembleDebug
```

## Links

- [App overview (YouTube)](https://www.youtube.com/watch?v=k_SF1qoTpvU)

---

*Note: This project targets older SDK 28 / Support Library APIs. Requires AndroidX, newer AGP, and revisiting deprecated Sceneform (Google’s Sceneform open-source fork or alternative viewers)*
