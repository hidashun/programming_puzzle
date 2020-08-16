package solution

/*
A,B,Cの3人が1～5の5枚のカードを使ってインディアンポーカーをします。
3人は、ランダムに1枚のカードを引いて額にかざします。相手のカードは見えますが、自分のカードは見えません。

この状態で、A->B->Cの順番に、自分が1番大きい（MAX）、自分は2番目に大きい（MID）自分が1番小さい（MIN）、わからない （?）、を答えます。

1人でも答えがわかった場合、そこで終了となります。「わからない」と答えた場合、回答権が次の人に移ります。 Cもわからない場合、再度Aに回答権が移ります。3人ともウソを言ったり、適当に答えてはいけません。

例1）「A=1 B=4 C=5」だった場合、「A => MIN」で終了します。

例2）「A=1 B=2 C=4」
だった場合、「A => ?, B => MID」で終了します。
Bは「Aがわからないなら、自分は5ではない」と考えるからです。

以上を踏まえて、

引数で「A=1 B=4 C=5」で実行すると「A =>MIN」を出力

引数で「A=1 B=2 C=4」で実行すると「A =>?, B =>MID」

を出力するようなコマンドラインのプログラムを作成してください。

なお、人数やカードの枚数がパラメーター化されていて、さまざまなケースがシミュレーションできるコードが望ましいです。
 */

object GuessRank {
  object Answer extends Enumeration {
    type Answer = Value
    val Unknown, Min, Mid, Max = Value
  }
  import Answer._

  object Solution {
    def getAnswers(cardByPlayers: Seq[Int], maxCardNumber: Int): Seq[Answer] = {
      assert(3 <= maxCardNumber)

      // 数の選択肢
      val cardNumbers: Seq[Int] = 1 to maxCardNumber

      // 人数
      val numOfPlayers = cardByPlayers.length
      assert(numOfPlayers <= cardNumbers.length)

      // 確実に確定できる他の人の数
      val cardsOfOtherPlayersIndicatingPlayerHasMax = cardNumbers.slice(0, numOfPlayers - 1).toSet
      val cardsOfOtherPlayersIndicatingPlayerHasMin = cardNumbers.slice(maxCardNumber - numOfPlayers + 1, maxCardNumber).toSet
      val cardsOfOtherPlayersIndicatingPlayerHasMid = (cardNumbers.slice(0, numOfPlayers - 2) ++ Seq(cardNumbers.last)).toSet

      // 判定
      @scala.annotation.tailrec
      def getAnswersForCardIndex(cardIndex: Int, answers: Seq[Answer]): Seq[Answer] = {
        val cardsOfOtherPlayers = cardByPlayers.zipWithIndex.filter { _._2 != cardIndex }.map(_._1)

        var cardCandidatesOfPlayer = cardNumbers.toSet.diff(cardsOfOtherPlayers.toSet)

        (0 until cardIndex) foreach {
          cardIndexOfPreviousPlayer =>
            cardCandidatesOfPlayer = cardCandidatesOfPlayer.filter {
              cardCandidateOfPlayer => {
                val cardsPreviousPlayerSaw = (
                  cardsOfOtherPlayers.zipWithIndex
                    .filter { _._2 != cardIndexOfPreviousPlayer }
                    .map(_._1)
                    :+ cardCandidateOfPlayer
                  ).toSet
                cardsPreviousPlayerSaw != cardsOfOtherPlayersIndicatingPlayerHasMax &&
                cardsPreviousPlayerSaw != cardsOfOtherPlayersIndicatingPlayerHasMid &&
                cardsPreviousPlayerSaw != cardsOfOtherPlayersIndicatingPlayerHasMin
              }
            }
        }

        if (cardCandidatesOfPlayer.forall(cardCandidateOfPlayer =>
          cardsOfOtherPlayers.forall(cardOfOtherPlayer => cardOfOtherPlayer < cardCandidateOfPlayer))) {
          return answers :+ Max
        }
        if (cardCandidatesOfPlayer.forall(cardCandidateOfPlayer =>
          cardsOfOtherPlayers.forall(cardOfOtherPlayer => cardCandidateOfPlayer < cardOfOtherPlayer))) {
          return answers :+ Min
        }
        if (cardCandidatesOfPlayer.forall(cardCandidateOfPlayer => {
          val rankIndex = (cardsOfOtherPlayers :+ cardCandidateOfPlayer).sorted.indexOf(cardCandidateOfPlayer)
          numOfPlayers - 2 <= rankIndex && rankIndex < numOfPlayers - 1
        })) {
          return answers :+ Mid
        }

        if (cardIndex + 1 < numOfPlayers) {
          getAnswersForCardIndex(cardIndex + 1, answers :+ Unknown)
        } else {
          answers :+ Unknown
        }
      }
      getAnswersForCardIndex(0, Nil)
    }
  }
}
