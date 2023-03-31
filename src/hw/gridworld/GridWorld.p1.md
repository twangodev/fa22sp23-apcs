# GridWorld.p1

1. Test the `setDirection` method with the following inputs and complete the table, giving the compass direction each
input represents.

    | Degrees  | Compass Direction |
    |----------|-------------------|
    | 0        | North             |
    | 45       | NorthEast         |
    | 90       | East              |
    | 135      | SouthEast         |
    | 180      | South             |
    | 225      | SouthWest         |
    | 270      | West              |
    | 315      | NorthWest         |
    | 360      | North             |

2. Move a bug to a different location using the `moveTo` method. In which directions can you move it? How far can you
move it? What happens if you try to move the bug outside the grid?

   You can move the bug anywhere, however you cannot change the direction of the bug without calling `setDirection` or 
   `turn`. An IllegalArgumentException is thrown if you try to move the bug outside the grid.
3. Change the color of a bug, flower, and a rock. Which method did you use?
 
    `setColor`
4. Move a rock on top of a bug and then move the rock again. What happened to the bug?

    The bug was removed from the grid. The bug no longer exists even after moving the rock.