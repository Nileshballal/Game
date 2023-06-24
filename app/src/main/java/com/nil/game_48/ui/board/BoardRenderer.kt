package com.nil.game_48.ui.board

import androidx.compose.runtime.Composable
import com.nil.game_48.ui.data.BoardModel
import com.nil.game_48.ui.tile.TileRenderer
import com.nil.game_48.ui.tile.TileRendererInstance

interface BoardRenderer {
    @Composable
    fun BoardScope.Render(boardModel: BoardModel)
}

internal object BoardRendererInstance :
    BoardRenderer,
    TileRenderer by TileRendererInstance {

    @Composable
    override fun BoardScope.Render(boardModel: BoardModel) {
        boardModel.staticTiles.forEach { tileModel -> RenderStaticTile(tileModel) }
        boardModel.swipedTiles.forEach { tileModel -> RenderSwipedTile(tileModel) }
        boardModel.mergedTiles.forEach { tileModel -> RenderMergedTile(tileModel) }
        boardModel.newTiles.forEach { tileModel -> RenderNewTile(tileModel) }
    }
}
