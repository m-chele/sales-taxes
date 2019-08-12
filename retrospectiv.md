# Spent time
about 11 hours working 1 hour a day (with a two weeks pause for holidays ;) )

# My assumptions
* parsing input is out of scope
* one row for each good (i.e "2 books at ..." is not allowed)


# Difficulties I encountered
## rounding
I didn't know an elegant way to round a number so I googled and I found a solution using `Math.random`:

taxPercentage = 0.5625

Math.round(0.5625 * 20) / 20.0 = 0.55

I thought this was correct because the kata instructions (see Readme.txt) say "...rounded up to the nearest 0.05" but
the "output 3" showed me that I got wrong because the tax amount of "imported chocolate" must be 0.6, so I corrected my
implementation with:

Math.ceil(0.5625 * 20) / 20.0  = 0.60

## design
I think I started in a "too much naive" way and initially I treated tax as dependecy of `Good`. This choice
took me to some difficulties when I wrote the AT 2 (introduction of "import tax"), so I refactored my code to define a
`Taxes` object that could operate on the base of the `Good` type.
At the end I'm not completely satisfied about the design, there are some violations of Single Responsibility Principle
and some coupling that could be reduced. For example:
* `Receipt` needs a collaborator for output, maybe a sort of general "display"
* there is duplication in objects of type `Row` (pheraps, not sure row is the best way to shape the problem)     
* test files are not organized


