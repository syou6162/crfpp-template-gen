# crfpp-template-gen
[CRF++](https://taku910.github.io/crfpp/)の素性テンプレートをClojureで簡単に書くためのツールです。

どのような素性を使えば大体分かっているタスク(例: チャンキング)では、素性テンプレートをそんなにいじる必要はありません。しかし、そうでないタスクは素性エンジニアリングを頑張る必要があります。CRF++の素性テンプレートは

```
U20:%x[-2,1]/%x[-1,1]/%x[0,1]
U21:%x[-1,1]/%x[0,1]/%x[1,1]
U22:%x[0,1]/%x[1,1]/%x[2,1]
```

のような形をしていますが、列が増えたり必要なくなって消す際などには、`U20`のような素性番号や列のidの修正をしなければなりません。他にも例えば、k-bestの木の素性を使いたい時に、kの数をちょっとづつ変える必要が出てきたときには素性テンプレートを修正するのは大変です。このスクリプトは、そのようなテンプレートをclojureで簡単に書けるようにするものです。

## Usage
[example.clj](src/crfpp_template_gen/example.clj)に例が載っているので、そこを参照してください。以下のような出力が得られます。

```
# word bigram
U0:%x[-2,0]/%x[-1,0]
U1:%x[-1,0]/%x[0,0]
U2:%x[0,0]/%x[1,0]
U3:%x[1,0]/%x[2,0]
# pos bigram
U4:%x[-2,1]/%x[-1,1]
U5:%x[-1,1]/%x[0,1]
U6:%x[0,1]/%x[1,1]
U7:%x[1,1]/%x[2,1]
```

## License

Copyright © 2015 Yasuhisa Yoshida

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
