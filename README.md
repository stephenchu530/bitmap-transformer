# bitmap-transformer

## Description
This program reads in bmp file, transforms it, then saves it to a file.

## Usage
```
 $ ./gradlew run --args '<src file> <dest file> <transform>'
```
example:
```
 $ ./gradlew run --args 'image1.bmp image2.bmp invert'
```

## Transforms List
* crazy - does something crazy to the pixel colors
* light - lightens the pixel colors
* invert - inverts the pixel color
* vflip - vertically flips the image
* hflip - horizontally flips the image


## Contributors
* Paula Thomas, [Paula9t9](https://github.com/Paula9t9)
* Stephen Chu, [stephenchu530](https://github.com/stephenchu530)

## License
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/stephenchu530/bitmap-transformer/blob/master/LICENSE)
