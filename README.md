# aNewSpring Assignment - Pandemic
## Assignment Subject
Build a simulation (using `JAVA`) that models this virus spread on a grid of `n`*`n` persons.<br />
The simulation, running over a number of `rounds`, will be based on the simple assumption that the virus spreads through `contact` between adjacent people.<br />
If the number of contacts reaches a `infection threshol`, a person will become `infected`.<br />
When an infected person is surrounded by more than a `recovery threshold` of infected people, the virus will die out and that person will `recover` and become uninfected again.<br />

For example, a simulation on an 8x8 grid, with 7 rounds, an infection threshold of 3,<br />
a recovery threshold of 6 and 3 infected persons to start with can be run with a command similar to the following:
```
java pandemic 8 7 3 6 [<4,7>,<4,8>,<5,8>,<6,8>]
```
After a number of rounds the output should be displayed.

## Assignment Solution
### File Structure
All `JAVA` files are in the `/Pandemic/src` directory under root repository.
### Run the program
Program can be run at root repository by command:
```
cd Pandemic; ./run.sh` + [required arguments]
```
There have to be 5 arguments provided by the following order:
1. `Grid scale`: has to be an integer no less than 1, no more than 5000 (in case of insufficient memory);
2. `Number of rounds`: has to be an integer no less than 1, no more than 1 million;
3. `Infection threshold`: has to be an integer no less than 1, no more than 7;
4. `Recovery threshold`: has to be an integer no less than 1, no more than 7;
5. `Initi infected people's location`: has to be a string, no white space allowed, has to have `"[]"` wrapped outside, a set of location has to be be in the format of `<[number],[number]>`, each set is seperated by a single `,`.

### Output
Simulation is printed in the standard output in a grid composed of either a `.` or a `X`.<br />
Uninfected person is represented by a green `.`.<br />
Infected person is representated by a red `X`.<br />
Initial grid and final grid after required number of rounds will be provided on standard output.<br />
It is possible to also print out each round: in file `/src/simulation/Simulation.jave`, in methods `run()` by passing argument `true` to `runRounds()` (at line 17).

