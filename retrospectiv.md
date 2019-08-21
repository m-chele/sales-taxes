# Spent time
about 17 hours, working 1 hour a day (with a two weeks pause for holidays ;) )

# My assumptions
* parsing input is out of scope
* one row for each good (i.e "2 books at ..." is not allowed)
* using double for money representation is ok

# Design
Initially I treated tax as dependecy of `Good`. This choice took me to some difficulties when I wrote the AT 2 (introduction of "import tax"), so I refactored my code to define a `Taxes` object that could operate on the base of the `Good` type (Chain of responsibility pattern).

At the end I wasn't completely satisfied about the design, so I created a `Display` collaborator to respect the "Single Responsibility Principle".

At this point I organized the `Receipt` creation as a Builder pattern and (mainly for study) I choosed to go deep in that pattern and I refactored the Builder to be a Checked Builder.
 
# Difficulties I encountered
## Rounding
I didn't know an elegant way to round a number so I googled and I found a solution using `Math.random`:

taxPercentage = 0.5625

Math.round(0.5625 * 20) / 20.0 = 0.55

I thought this was correct because the kata instructions (see Readme.txt) say "...rounded up to the nearest 0.05" but
the "output 3" showed me that I got wrong because the tax amount of "imported chocolate" must be 0.6, so I corrected my
implementation with:

Math.ceil(0.5625 * 20) / 20.0  = 0.60

# Things I learned
* Checked Builder pattern
  * in particular I noted that is an intelligent way to ensure correctness of an object initialization at compile time 
* redefine Enum using interfaces
 

# Next steps 
* improve tests
* isolate totalPriceFor(Good)
* isolate formatting row responsibility