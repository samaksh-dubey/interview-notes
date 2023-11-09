## Why Hashing ?

1. Fastest method to search for a key
2. Better than binary & linear search

**Drawback of Hashing** = Requires extra space

## Relational Mapping

1. One to One
2. One to Many
3. Many to One
4. Many to Many

One to One & Many to One = function

## Hashing Function

The function used for calculating hash of a key is called hashing function.

**Ideal Hashing** = One to One hash function is called ideal hashing. Drawback of ideal hashing is very huge.

To save space we need to modify hash function e.g. if h(x) is ideal hash and we need to limit space to size 10 then we can have

g(x) = h(x)  % 10

**Modified Hash Function** = This might lead of **Hash Collision** i.e. two or more keys mapped to same place i.e. ideal hash function changes its character and becomes Many to One.

## Resolve Hash Collision

**Open Hashing** = It consumes extra space.

1. Chaining =

**Closed Hashing** = It utilize the space which is already provided.

1. Linear Probing
2. Quadratic Proding
3. Double HashingLoading Factor = Number of Keys / Size of Hash Table

**Loading Factor** = Number of Keys / Size of Hash Table

## Other Hashing Functions

1. Mod
2. Mid Square
3. Folding
