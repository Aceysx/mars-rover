```

          N|y
          |
W---------|----------->x E
          |
          |
          S|
```

1. 始化信息：火星车的降落地点（x, y）和朝向（N, S, E, W）信息；
- 可以初始化一个火星车，并指定它的落脚点和朝向

2. 移动指令：火星车可以前进（M）,一次移动一格；
- 火星车可以接收一个前进的指令，当火星车朝向 E 时，那么接收到一个前进指令后，那么 x 值应该 +1
- 火星车可以接收一个前进的指令，当火星车朝向 W 时，那么接收到一个前进指令后，那么 x 值应该 -1
- 火星车可以接收一个前进的指令，当火星车朝向 N 时，那么接收到一个前进指令后，那么 y 值应该 +1
- 火星车可以接收一个前进的指令，当火星车朝向 S 时，那么接收到一个前进指令后，那么 y 值应该 -1

3. 转向指令：火星车可以左转90度（L）或右转90度（R）。
- 火星车可以接收到左转的指令，火星车的朝向将逆时针转向（N W S E N...
- 火星车可以接收到右转的指令，火星车的朝向将顺时针转向（N E S W N...

4. 接收一个进入倒车状态的指令 B 和取消倒车状态 H 指令
- 接收到指令 B 进入倒车状态后
    - 火星车可以接收一个前进的指令，当火星车朝向 E 时，那么接收到一个前进指令后，那么 x 值应该 -1
    - 火星车可以接收一个前进的指令，当火星车朝向 W 时，那么接收到一个前进指令后，那么 x 值应该 +1
    - 火星车可以接收一个前进的指令，当火星车朝向 N 时，那么接收到一个前进指令后，那么 y 值应该 -1
    - 火星车可以接收一个前进的指令，当火星车朝向 S 时，那么接收到一个前进指令后，那么 y 值应该 +1
    - 火星车可以接收到左转的指令，火星车的朝向将顺时针转向（N W S E N...
    - 火星车可以接收到右转的指令，火星车的朝向将逆时针转向（N W S E N...
- 接收到指令 H 取消倒车状态


5. 有一个雷达功能，执行完判断一下自己是不是掉沟里了，如果掉沟里了，就再map上打个记号X（只是表达这个意思，不一定非要是字符串X），
后面的rover会忽略走向这个记号的命令（当火星车掉到沟里时，调用init方法创建一辆新的火星车，但旧的火星车还要在沟里，不能消失）
- 有一个地图，地图上标注了有多个陷阱的坐标的集合
- 有一个记录了若干个有陷阱的坐标的地图（无边界），当火星车每次接收一个移动的指令时，如果遇到了陷阱（该陷阱中没有火星车）
    - 那么该车将会无法移动，停留在原地
    - 那么会出现一辆新的火星车
- 当火星车接收到一个移动指令且遇到一个陷阱，陷阱中有火星车时，那么当前指令不会生效（即原地不动）

6. 车也有状态，有的状态，车会忽略一些指令，比如左转坏了，会忽略左转指令
- 当小车左转坏了，那么将会忽略左转指令
- 当小车右转坏了，那么将会忽略右转指令
- 当小车前进坏了，那么将会忽略前进指令
- 当小车后退坏了，那么将会忽略后退指令

7. 新增一个bus类型的车，占两格，坐标是车头的坐标，但是在拐弯时周围必须有空间否则忽略指令
- 对于bus类型的车，在接收到前进指令时，那么会和普通的火星车一样前进一格
- 对于bus类型的车，在接收到后退指令时，那么会和普通的火星车一样后退一格

- 对于bus类型的车，在接收到左拐指令时，如果右侧两格没有陷阱（陷阱中有车），那么正常左拐(面向 N.W.S.E 不同方向)
- 对于bus类型的车，在接收到左拐指令时，如果右侧两格有一个或两格陷阱（陷阱中有车），那么忽略指令
- 对于bus类型的车，在接收到右拐指令时，如果左侧两格没有陷阱（陷阱中有车），那么正常左拐(面向 N.W.S.E 不同方向)
- 对于bus类型的车，在接收到右拐指令时，如果左侧两格有一个或两格陷阱（陷阱中有车），那么忽略指令