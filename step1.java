最初の方針

方針だけ考えてみる

一連のメールアドレス整形処理（下）
ーーーーーーーーーーーーーーーー
String[]で渡されてくる各要素を、＠以前：localNameと＠以後：domainNameに分けて、例えばリストに格納する。　.split()とか。
localNameをchar(Character)に変換し、走査する。　.が入っていた場合、それを削除する（ある種の正規化？）そして、（インプレースで？）新しいStringにする
localNameに＋が入っていた場合、+以後を全削除する
domainNameに関しては、そのまま放置

これらの処理を行ったのち、再びlocalNameと＠とdomainNameをガッチャンコ（concatenateし）、セットとして格納する。
ーーーーーーーーーーーーーーーー

上記をforループの中で行う
次に来るものをset.contains()で突き合わせ、もし存在しなかったら新しくセットに加え（↑の処理を施す）、存在する場合はセットに加えない
セットのサイズset.size()を返す。

↓回答コードの写経



class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            //@で分割してローカル名とドメイン名に分ける　正規表現で分ける。
            String[] parts = email.split("@");
            String localName = parts[0];
            String domainName = parts[1];

            int plusIndex = localName.indexOf('+');
            if (plusIndex != -1) {
                localName = localName.substring(0, plusIndex);
            }//str.substring(int beginIndex, int endIndex);
            //不正なインデックスを指定すると、StringIndexOutOfBoundsExceptionがスローされる
            //元の文字列は変更されず、新しい文字列オブジェクトが生成される。

            //ローカル名のドットを削除
            localName = localName.replace(".", "");

            String normalizedEmail = localName + "@" + domainName;
            uniqueEmails.add(normalizedEmail);
        }

        return uniqueEmails.size();
    }
}
オーバーロード
indexOf(int ch)
indexOf(String str)
Javaではcharは16ビット（0〜65535）の値で、実際には内部的にはUnicodeの値として扱われています
    ユニコードUniCode(Unique Code)コードポイント＝一意の数値識別子

Javaのchar型（0から65535）は以下の文字や記号をカバーしています：

基本ラテン文字（ASCII文字）

英数字、記号、制御文字（0-127）


ラテン文字拡張

アクセント付きラテン文字、その他の西欧言語の文字


ギリシャ文字、キリル文字
ヘブライ文字、アラビア文字
インド系文字（デーヴァナーガリー、タミル文字など）
タイ文字、ラオス文字
日本語の平仮名、片仮名
中国語、日本語、韓国語（CJK）の基本漢字（BMP内の漢字）

約2万字の基本的な漢字


ハングル文字（韓国語）
各種記号、矢印、数学記号、通貨記号
図形要素、罫線

これらはUnicodeの「基本多言語面」(Basic Multilingual Plane, BMP)に含まれる文字です。
    基本多言語面！Basic Multilingual Plane面　BMP
if (plusIndex != -1)は「プラス記号が見つかった場合」という条件を表しています。プラス記号が存在しない場合は-1が返され、条件に当てはまらないので処理をスキップします。
これは一般的にJavaで文字列内の特定の文字を検索する際の標準的なパターンです。
文字列リテラル：
「ソースコードにそのまま書かれた文字列の値」です。これはJavaコンパイラによって特別に処理され、文字列プール(String Pool)と呼ばれる特別な領域に保存されます。
Javaのchar型は16ビット（0〜65535）の範囲のコードポイントしか直接表現できないため、それ以上の値を表すには2つのchar値（サロゲートペア）を使います。indexOf(int ch)のような一部のメソッドは、より広い範囲のUnicodeコードポイントを扱えるようint型を使用しています。
