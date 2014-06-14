# poj-lab-2

## Zadanie

-	Z użyciem wzorca projektowego *Builder* należy stworzyć interfejsy i klasy
    umożliwiające klientom tych interfejsów i klas budowanie dokumentów
    tekstowych oraz HTML w sposób niezależny od konkretnej formy wizualnej
    budowanego dokumentu.
-	Zbudowane dokumenty TXT i HTML klient będzie prezentował na konsoli
    (ambitniejsi studenci mogą od razu zapisywać je do plików)
-	Klient w/w interfejsów i klas musi mieć możliwość określania następujących
    elementów dokumentu:

    -	tytułu dokumentu
    -	autora dokumentu
    -	tytułów rozdziałów (zakładamy cztery poziomy nagłówków)
    -	akapitów
    -	list wypunktowanych

-	Konkretne wizualizacje dokumentów mają wyglądać co najmniej przyzwoicie (w
    przypadku dokumentu HTML ta sama uwaga dotyczy kodu).
-	Należy sparametryzować to, czy klasy odpowiedzialne za budowanie
    wizualizacji dokumentów mają numerować rozdziały czy nie.

## Specyfikacja

- Intellij IDEA

### Uruchomienie

- Konfiguracja: JDK
- Stworzenie: Application
- Start: Ctrl+R

## Wyjątki w Java

* Error
  Wyjątki rzucane przez wirtualną maszynę Java
  Nigdy nie łapiemy tych wyjątków

* Exceptions

    - oznaczone: Rozszerzają klasę Exception.
      Wyjątki rzucane przez biblioteki. Musimy obsłużyć.
      Wyjątki nie są rzucane przez programistę, pojawiają się nie z powodu błędu programisty.

    - nieoznaczone: RuntimeException
      Wyjątki rzucane przez programistów. Nie obsługujemy ich.

### Dod. zadanie

*Wzorzec obiektowy obserwator.*
