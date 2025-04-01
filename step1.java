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

if (plusIndex != -1)は「プラス記号が見つかった場合」という条件を表しています。プラス記号が存在しない場合は-1が返され、条件に当てはまらないので処理をスキップします。
これは一般的にJavaで文字列内の特定の文字を検索する際の標準的なパターンです。

