$(function() {
  var name;
  var VintageTxtTest = {

    el : $('#doThis'),

    go : function go() {
      this.el.vintageTxt({
         text : ["ただいま読み込み中.  .  .  "]
        ,textSpeed: 300
        ,promptEnabled: false
        ,onFinishedTyping : this.intro
      });

    },

    intro : function intro() {
      var texts = [
        ["Just Complete!","Java演習ページにようこそ!"]
        ,["ここは、僕が初めてJavaによりプログラミングした、グラフの課題を表示するページです。","よろしければ名前を教えてください。"]
      ];

      self.el.vintageTxt('updateOptions', {
        textSpeed: 60
        ,onFinishedTyping : null
        ,onEnterKey : self.pageOne
        ,promptEnabled : true
      });
      self.el.vintageTxt('playMany',texts);
    },

    pageOne : function pageOne(e, inputTxt) {
      name = inputTxt;
      var texts = [
        ["あなたの名前は, " + inputTxt + "さんですね?","閲覧して頂きありがとうございます！","粗末なものしかありませんが、ゆっくりしていってください。",
        inputTxt + "さんのお時間を少しばかり頂かせてもらいます。","1. BarGraph","2. LineGraph","3. PieChart","4. RaderChart","どの説明についてみたいですか？番号を入力してください。"]
      ];

      self.el.vintageTxt('updateOptions', {
        maxRows : 5
        ,onFinishedTyping : null
        ,onEnterKey : self.pageThree
        ,promptEnabled : true
      });
      self.el.vintageTxt('playMany',texts);
    },

    pageTwo : function pageTwo(e, inputTxt) {
      if(inputTxt == 1 || inputTxt == "１"){
        self.el.vintageTxt('reset'
          ,["日本国民は、正当に選挙された国会における代表者を通じて行動し、","われらとわれらの子孫のために、諸国民との協和による成果と、","わが国全土にわたって自由のもたらす恵沢を確保し、政府の行為によって再び戦争の惨禍が起ることのないやうにすることを決意し、","ここに主権が国民に存することを宣言し、この憲法を確定する。そもそも国政は、国民の厳粛な信託によるものであって、","その権威は国民に由来し、その権力は国民の代表者がこれを行使し、その福利は国民がこれを享受する。","これは人類普遍の原理であり、この憲法は、かかる原理に基づくものである。","われらは、これに反する一切の憲法、法令及び詔勅を排除する。","日本国民は、恒久の平和を念願し、人間相互の関係を支配する崇高な理想を深く自覚するのであって、平和を愛する諸国民の公正と信義に信頼して、われらの安全と生存を保持しようと決意した。われらは、平和を維持し、専制と隷従、圧迫と偏狭を地上から永遠に除去しようと努めている国際社会において、名誉ある地位を占めたいと思ふ。われらは、全世界の国民が、ひとしく恐怖と欠乏から免れ、平和のうちに生存する権利を有することを確認する。われらは、いづれの国家も、","自国のことのみに専念して他国を無視してはならないのであって、","政治道徳の法則は、普遍的なものであり、この法則に従ふことは、自国の主権を維持し、","他国と対等関係に立たうとする各国の責務であると信ずる。","日本国民は、国家の名誉にかけ、全力をあげてこの崇高な理想と目的を達成することを誓ふ。","","1. BarGraph","2. LineGraph","3. PieChart","4. RaderChart","どの説明についてみたいですか？番号を入力してください。"]

          ,{  textSpeed : 10
            ,linePause : 200
            ,maxRows : 7
            ,promptEnabled : true
            ,onEnterKey : self.pageThree
            ,onFinishedTyping : null
          }
        );
      }else if(inputTxt == 2 || inputTxt == "２"){
        self.el.vintageTxt('reset'
          ,["じゅげむ","じゅげむ","ごこうのすりきれ","かいじゃりすいぎょの","すいぎょうまつ","うんらいまつ","ふうらいまつ","くうねるところに","すむところ","やぶらこうじの","ぶらこうじ","パイポパイポ","パイポのシューリンガン","シューリンガンのグーリンダイ","グーリンダイのポンポコピーの","ポンポコナーの","ちょうきゅうめいのちょうすけ","","1. BarGraph","2. LineGraph","3. PieChart","4. RaderChart","どの説明についてみたいですか？番号を入力してください。"]
            ,{  textSpeed : 10
            ,linePause : 200
            ,maxRows : 7
            ,promptEnabled : true
            ,onEnterKey : self.pageThree
            ,onFinishedTyping : null
          }
        );

      }else if(inputTxt == 3 || inputTxt == "３"){
        self.el.vintageTxt('reset'
          ,["パブロ","・","ディエゴ","・","ホセ","・","フランシスコ","・","デ","・","パウラ","・","フアン","・","ネポムセーノ","・","マリア","・","デ","・","ロス","・","レメディオス","・","シブリアーノ","・","センティシマ","・","トリニダード","・","ルイス","・","イ","・","ピカソ","","1. BarGraph","2. LineGraph","3. PieChart","4. RaderChart","どの説明についてみたいですか？番号を入力してください。"]
          ,{  textSpeed : 10
            ,linePause : 200
            ,maxRows : 7
            ,promptEnabled : true
            ,onEnterKey : self.pageThree
            ,onFinishedTyping : null
          }
        );
      }else if(inputTxt == 4 || inputTxt == "４"){
        self.el.vintageTxt('reset'
          ,["東京(とうきょう)","有楽町(ゆうらくちょう)","新橋(しんばし)","浜松町(はままつちょう)","田町(たまち)","品川(しながわ)","大崎(おおさき)","五反田(ごたんだ)","目黒(めぐろ)","恵比寿(えびす)","渋谷(しぶや)","原宿(はらじゅく)","代々木(よよぎ)","新宿(しんじゅく)","新大久保(しんおおくぼ)","高田馬場(たかだのばば)","目白(めじろ)","池袋(いけぶくろ)","大塚(おおつか)","巣鴨(すがも)","駒込(こまごめ)","田端(たばた)","西日暮里(にしにっぽり)","日暮里(にっぽり)","鶯谷(うぐいすだに)","上野(うえの)","御徒町(おかちまち)","秋葉原(あきはばら)","神田(かんだ)","","1. BarGraph","2. LineGraph","3. PieChart","4. RaderChart","どの説明についてみたいですか？番号を入力してください。"]
          ,{  textSpeed : 10
            ,linePause : 200
            ,maxRows : 7
            ,promptEnabled : true
            ,onEnterKey : self.pageThree
            ,onFinishedTyping : null
          }
        );

      }else{
        self.el.vintageTxt('reset'
          ,["なんですか"+name+"さん。","なめてるんですか？",inputTxt + "じゃあないですよ",inputTxt + "じゃあ！", "ソロソロオコリマスヨ"," ","1. BarGraph","2. LineGraph","3. PieChart","4. RaderChart","どれについての説明をみたいですか？"]
          ,{  textSpeed : 90
            ,linePause : 800
            ,maxRows : 5
            ,promptEnabled : true
            ,onEnterKey : self.pageThree
            ,onFinishedTyping : null
          }
        );
      }
    },

    pageThree : function pageThree(e, inputTxt) {
      if(inputTxt == 1 || inputTxt == "１"){
        self.el.vintageTxt('reset'
          ,["1番の,BarGraphの説明をしますね。","これは本来課題には入ってないものですが、自分の自己満の為に入れてしまいました。","八個しか縦棒がないのは、これが一番美しく棒グラフを表示できると独断と偏見で判断したからです。","コードは至って簡単で、80行ほどで書きました。削ろうと思えばたくさん削れると思います。","こだわった点としては、上部の丸みと、下の尖っているところですかね。fillOvalとpolygonを使いました。","これ、遠目から見るとパックマンとかプッカみたいなんですよね。","色もパーセンテージに合わせて変化します。","このころはまだ透過色及びグラデーションがかけられる事を知らなかったので、","べた塗りの雑な仕様となっています。","パーセントの値が読みにくいのは仕様です。","見にくい文字にする事によって、",name+"さんの視力を鍛えてやろうという理由からです。(適当)"," ","1. BarGraph","2. LineGraph","3. PieChart","4. RaderChart","どれについての説明をみたいですか？"]
          ,{  textSpeed : 90
            ,linePause : 800
            ,maxRows : 5
            ,promptEnabled : true
            ,onEnterKey : self.pageThree
            ,onFinishedTyping : null
          }
        );
      }else if(inputTxt == 2 || inputTxt == "２"){
        self.el.vintageTxt('reset'
          ,["2番の,LineGraphの説明をします。","このグラフは一番作るの簡単だった気がします。","処理系は、点の数と線の数に注意して、実装した以外、特に注意したところはありませんでした。","ただ、普通のままでは味気ないので、グラデーションを使おうとしたため、余計な手間がかかることになります。","xが0におけるy軸方向の丸ぽちは、0番目の要素が己を超えているか超えていないかで、","色をつけるかつけないかを判断させています。","このころColorオブジェクトを変数的に上手く扱う方法になれてなく、","違和感無いグラデーションに苦戦した事を覚えています。","といっても、所詮は描画するだけの作業ですから、コツをつかめばすぐできました。","ここでの経験はRaderChartを作るときに活きてきます。","説明としては以上です。いやあ、しかし何だろう、","こういうデザインとかみられると、自分の性癖とかばれそうで怖いですね(笑)","","1. BarGraph","2. LineGraph","3. PieChart","4. RaderChart","どれについての説明をみたいですか？"]
          ,{  textSpeed : 90
            ,linePause : 800
            ,maxRows : 5
            ,promptEnabled : true
            ,onEnterKey : self.pageThree
            ,onFinishedTyping : null
          }
        );

      }else if(inputTxt == 3 || inputTxt == "３"){
        self.el.vintageTxt('reset'
          ,["3番の,PieChartの説明をします。","課題本来のものは、典型的な円グラフですが、","これは. . .",". . . . .","はい、完全に蛇足ですね。いやですね、これを作ったときに,自分の中で何かこう、","サマーウォーズ的なあれにしたいという変な願望があってですね、少し遊んでしまいました(白目)","しかもこのグラフ、実は欠陥があるんですにょね。周りの変な渦巻いてる奴は、","中の小さな円グラフの最大値に対する各要素のパーセント表なのですが、実はこれ、八個までしか表示されません(震え声)","なぜかというと、そうですね、デザインを重視した結果ですねｗ","白枠を、400×250で作っているのですが、この中で綺麗におさめようとすると、八個くらいが限界なんですよね。","これ以上要素を増やすと、ゲージ幅を細くした場合ただでさえ見にくいものがさらに見にくくなるし、外周に継ぎ足すと画面からはみ出ちゃいます。","なので、まあ普通の円グラフとしての機能は果たせると思うし、ご愛嬌ってことで勘弁してください(笑)","","","1. BarGraph","2. LineGraph","3. PieChart","4. RaderChart","どれについての説明をみたいですか？"]
          ,{  textSpeed : 90
            ,linePause : 800
            ,maxRows : 5
            ,promptEnabled : true
            ,onEnterKey : self.pageThree
            ,onFinishedTyping : null
          }
        );
      }else if(inputTxt == 4 || inputTxt == "４"){
        self.el.vintageTxt('reset'
          ,["4番の,RaderChartの説明をします。","いやあ、正直これが一番苦戦しましたね。","まずはじめに、先生の話をあまり聞いていなかったせいで、Math.pieを使ってあげる事を知りませんでした(汗)","ひとよんで、Mathクラス 三角関数メソッドの罠、です。その為、弧度法やらなんやらのところで一番悩みましたね。","ほかの処理については特に迷う事はありませんでした。","値に対して、その点をレーダーチャートに描画する事から初めて、","次にその点同士を結んで、最終的にpolygonを用いて中に透過色の図形を作るというだけの事です。","簡単ですね。タンポポをお刺身の上に乗っけるお仕事くらい簡単です。","こうして出来たものに対して、RadicalGradientPaintオブジェクトを生成して、淡い光をつけて","なんかこう、ちょっと発光している感じにしたのがこのグラフです。","あ、あとレーダーチャートならば、平均的なデータも必要かなと思って黄色い図形でそれも描画しています。","これがあるおかげで、一気にネオンっぽくなりました(笑)","","","1. BarGraph","2. LineGraph","3. PieChart","4. RaderChart","どれについての説明をみたいですか？"]
          ,{  textSpeed : 90
            ,linePause : 800
            ,maxRows : 5
            ,promptEnabled : true
            ,onEnterKey : self.pageThree
            ,onFinishedTyping : null
          }
        );

      }else{
        self.el.vintageTxt('reset'
          ,["番号以外のものを入力しましたね"+name+"さん。","仕方ないです、ラッキーということで、私の特技である早口言葉を見せてさしあげましょう。","","1. 日本国憲法前文","2. じゅげむ","3. ピカソの名前","4. 山手線全駅名"]
          ,{  textSpeed : 90
            ,linePause : 800
            ,maxRows : 5
            ,promptEnabled : true
            ,onEnterKey : self.pageTwo
            ,onFinishedTyping : null
          }
        );
      }
    },

    pageFour : function pageFour() {
      self.el.vintageTxt('reset'
        ,["Not to mention the callbacks!","Oh, the callbacks!"," ","Watch what happens when I'm done typing..."]
        ,{ maxRows : 10
           ,onFinishedTyping : function(){setTimeout(self.spawnNew, 2000);}
         }
      );
    },

    spawnNew : function spawnNew() {
      $('#miniTxt').vintageTxt({
        promptEnabled : false
        ,onFinishedTyping : function(){setTimeout(self.finalPage, 1000);}
      });
    },

    finalPage : function finalPage() {
      self.el.vintageTxt('reset'
        ,["So there you have it.","And plenty more features,","coming soon!","... in my imagination.","... so proabably never."," ","But never mind that.","Best to enjoy what you have,","and be greatful."," ","ttfn"]
        ,{  onFinishedTyping: null
           ,onEnterKey: null
           ,promptEnabled : true
         }
      );
    }

  }
  var self = VintageTxtTest;

  VintageTxtTest.go();

});
