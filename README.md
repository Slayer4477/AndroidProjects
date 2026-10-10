# Lab 8 & Practice 5 - Android App

Bu loyiha Jetpack Compose va Material 3 da yozilgan o'quv laboratoriya ishi hisoblanadi.

## Nimalar qilingan:
- **Part A:** remember va rememberSaveable orqali stateni saqlash va state hoisting.
- **Part B:** ViewModel va Sealed Interface yordamida yozilgan Sign-In (Kirish) ekrani.
- **Part C:** Artistlarni tanlash uchun Taste Picker ekran va grid qismi, hamda Unit testlar.
- **Practice 5:** Compose Modifier va Material 3 savollarining javoblari (Q1-Q42).

## Texnologiyalar:
- Kotlin & Jetpack Compose
- Material 3
- ViewModel
- JUnit Unit Tests

---

# Practice 5 — Savol va Javoblar (Q1 – Q42)

## Part A — Compose Modifier Asoslari (Q1–15)

### Q1: Column ga qanday padding beriladi?
Javob: Modifier.padding(16.dp) yordamida beriladi.

### Q2: Elementni butun ekranga egallash?
Javob: Modifier.fillMaxSize() ishlatamiz.

### Q3: Element o'lchamini belgilash?
Javob: Modifier.size(48.dp) bilan eni va bo'yi belgilanadi.

### Q4: Doira shaklida qirqish (clip)?
Javob: Modifier.clip(CircleShape) qilamiz.

### Q5: Fon rangini berish?
Javob: Modifier.background(Color.Red) beriladi.

### Q6: Ramka (Border) chizish?
Javob: Modifier.border(2.dp, Color.Black, CircleShape) yoziladi.

### Q7: Bosinganini (Click) ushlash?
Javob: Modifier.clickable { onClick() } ishlatilinadi.

### Q8: Row ichida nisbatan kenglik berish?
Javob: RowScope ichida Modifier.weight(1f) beramiz.

### Q9: Ustun va satrda markazlashtirish?
Javob: Alignment.CenterHorizontally yoki Arrangement.Center bilan qilinadi.

### Q10: Proportsional joy ajratish?
Javob: Row ichida .weight(2f) va .weight(1f) berib qoldiq bo'shliqni 2:1 qilib bo'lamiz.

### Q11: Box ichidagi rasmni markazga qo'yish?
Javob: Box(contentAlignment = Alignment.Center) va ichidagi rasmga align(Alignment.Center) beramiz.

### Q12: Qayta ishlatiluvchi composable-da Modifier idiomalari?
Javob: fun UserAvatar(name: String, modifier: Modifier = Modifier) deb yozib modifier'ni birinchi bo'lib ildiz elementga berish kerak.

### Q13: Text-ni natural hajmini saqlab markazga qo'yish?
Javob: Modifier.fillMaxSize().wrapContentSize(Alignment.Center) yoziladi.

### Q14: 16:9 proporsiyada rasmni avto-cho'zish?
Javob: Modifier.fillMaxWidth().aspectRatio(16f / 9f) ishlatamiz.

### Q15: Doiraviy Avatar Modifier ketma-ketligi?
Javob: size(56.dp) keyin border, keyin padding, keyin clip va oxirida background beriladi.

## Part B — Advanced Modifier Amaliyoti (Q16–30)

### Q16: Settings ekrani sig'mayapti, scroll qilish kerak.
Javob: Column ga Modifier.verticalScroll(rememberScrollState()) beramiz.

### Q17: Filter chip'lari ekrandan chiqib ketyapti, yonga scroll kerak.
Javob: Row ga Modifier.horizontalScroll(rememberScrollState()) yozamiz.

### Q18: QA button textiga qaramasdan topishi uchun testda id bering.
Javob: Modifier.testTag("submit_button") beriladi, testda esa onNodeWithTag bilan topiladi.

### Q19: Chiziq divider va Warning ikonka accessibility farqi nima?
Javob: divider oddiy bezak shunga contentDescription = null bo'ladi. Warning ikonka muhim shunga TalkBack o'qishi uchun contentDescription = "Warning" beriladi.

### Q20: Card fade animatsiyasini recomposition qilmasdan graphicsLayer bilan yozing.
Javob: Card(modifier = Modifier.graphicsLayer { alpha = animatedAlpha }) chunki drawing bosqichida o'qiladi va har kadrda recomposition bo'lmaydi.

### Q21: Rotate va scale'ni birga graphicsLayer'da yozing.
Javob: bitta graphicsLayer ichida rotationZ va scaleX/scaleY yoziladi, alohida modifier'larga qaraganda tezroq ishlaydi.

### Q22: Birinchi card ikkinchisini ustida ko'rinsin drag bo'lganda.
Javob: Modifier.zIndex() ishlatiladi, drag bo'lganda 1f, boshqa payt 0f beriladi.

### Q23: dashedBorder funksiyasi va u @Composable bo'lishi kerakmi?
Javob: @Composable shart emas, chunki u state o'qimaydi. fun Modifier.dashedBorder(...) qilib extension yoziladi.

### Q24: Map marker pin tap va long-press ikkalasini ushlash.
Javob: combinedClickable ishlatamiz, ichida onClick va onLongClick bo'ladi.

### Q25: size(100.dp) vs requiredSize(100.dp) farqi 60dp papkada?
Javob: requiredSize ota elementning 60dp chekloviga qaramasdan baribir 100dp qiladi. Oddiy size esa 60dp ga kichrayib qoladi.

### Q26: Chat LazyColumn va birinchi/oxirgi padding xatosi.
Javob: padding o'rniga contentPadding = PaddingValues(16.dp) ishlatish kerak, shunda skrol kesilib qolmaydi.

### Q27: Avatar orqasidagi glow Box rasmni razmeriga mos bo'lsin.
Javob: BoxScope dagi matchParentSize() beriladi. fillMaxSize ota elementni kattalashtirib yuboradi, bu esa faqat rasmni bo'yiga moslaydi.

### Q28: fun myRow() ichida .weight(1f) xatosi va yechimi.
Javob: weight faqat RowScope ichida ishlaydi. Yechimi funksiyani fun RowScope.myRow() deb yozish kerak.

### Q29: Tabletda search bar 80% enida o'rtada tursin.
Javob: Modifier.fillMaxWidth(0.8f).wrapContentWidth(Alignment.CenterHorizontally) yoziladi.

### Q30: background'dan keyin clip qo'yganda burchak chetlanmadi, nega?
Javob: ketma-ketlikda background oldin to'liq chizilib bo'lgan. clip oldin kelishi kerak yoki background'ning o'ziga shape berish kerak.

## Part C — Material 3 va Responsive Layout (Q31–42)

### Q31: Material Design nega oddiy skin emas?
Javob: chunki u shunchaki ranglar emas, balki Color, Typography, Shape, Motion va Elevation larni o'z ichiga olgan yaxlit tizim.

### Q32: Dynamic Color nima va qaysi API kerak?
Javob: foydalanuvchi oboyidan (wallpaper) rang ajratib olib ilovaga beradi. Android 12 (API 31) va undan yuqori versiya kerak.

### Q33: Material 2 va Material 3 ranglar farqi?
Javob: M2 da qattiq va kam sonli ranglar bor edi. M3 da esa Tonal palette orqali har bir rol uchun Container va On-Container variantlari avto yaratiladi.

### Q34: Snackbar va Card shakllari nega o'zgardi?
Javob: M2 da 3 ta shakl kategoriyasi bor edi, M3 da 7 ta bo'ldi. Tugmalar va chip'lar ko'proq yumshoq doira shakliga o'tkazildi.

### Q35: AppTheme dagi SDK check nega kerak?
Javob: API 31 dan past versiyalarda dynamicLightColorScheme xato (crash) bermasligi uchun tekshiriladi.

### Q36: Save, Preview, Cancel button'lar tanlovi?
Javob: Save asosiy harakat bo'lgani uchun Button (Filled), Preview uchun FilledTonalButton, Cancel uchun esa Outlined tugma ishlatiladi.

### Q37: WindowSizeClass 3 ta breakpoint.
Javob:
Compact: <600dp (telefonlar)
Medium: 600-839dp (planshetlar)
Expanded: >=840dp (katta ekranlar/desktop)

### Q38: Adaptiv nav bar when kodi.
Javob:
Kotlin
when (windowSizeClass.widthSizeClass) {
WindowWidthSizeClass.Compact -> BottomNavigationBar()
WindowWidthSizeClass.Medium -> NavigationRail()
WindowWidthSizeClass.Expanded -> PermanentNavigationDrawer {}
}

### Q39: Manual dp va bir marta startup'da check qilish xatosi?
Javob: qo'lda dp tekshirish xatoga moyil. Startup'da bir marta tekshirilsa esa ekran burilganda yoki foldable telefonda o'zgarganda ishlamay qoladi.

### Q40: textView.text = "$count" nega Compose'da xato?
Javob: Views'da vidjetni o'zimiz topib qo'lda o'zgartirardik. Compose esa deklarativ, ya'ni state o'zgarsa UI o'zi avtomatik yangilanadi.

### Q41: remember siz mutableStateOf va recomposition?
Javob: remember bo'lmasa ekran har safar qayta chizilganda state nolga (0) qaytib qoladi. Recomposition esa state o'zgarganda faqat o'sha o'qigan joyni qayta ishlatishdir.

### Q42: Counter'ni state hoisting qilish kodi va foydasi?
Javob: State'ni yuqoriga chiqarish composable'ni stateless qiladi, bu esa uni test qilish va qayta ishlatishni osonlashtiradi.
