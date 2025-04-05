# TestPacket

## プラグイン説明
パケットテスト用プラグイン

## プラグインダウンロード
[ダウンロードリンク](https://github.com/ringoame196-s-mcPlugin/TestPacket/releases/latest)

## テスト機能
<details>
    <summary>PacketType.Play.Server.EXPLOSION</summary>

```kotlin
        val loc = player.location
        val packet = PacketContainer(PacketType.Play.Server.EXPLOSION)

        // 爆発位置を指定
        packet.doubles.writeSafely(0, loc.x)
        packet.doubles.writeSafely(1, loc.y)
        packet.doubles.writeSafely(2, loc.z)

        // 爆発の強さ（見た目の大きさ）
        packet.float.writeSafely(0, 15.0f)

        // プレイヤーを上方向へ飛ばす加速度 (motionX, motionY, motionZ)
        packet.float.writeSafely(1, 0.0f) // X方向の力
        packet.float.writeSafely(2, 1.0f) // Y方向の力（上に飛ばす）
        packet.float.writeSafely(3, 0.0f) // Z方向の力

        protocolLibraryManager.sendServerPacket(player, packet)
```
</details>
 
## 開発環境
- Minecraft Version : 1.20.1
- Kotlin Version : 1.8.0

## プロジェクト情報
- プロジェクトパス : ringoame196-s-mcPlugin/TestPacket.git
- 開発者名 : ringoame196-s-mcPlugin
- 開発開始日 : 2025-04-02
