"use strict";

const autoprefixer = require("gulp-autoprefixer");
const gulp = require("gulp");
const imagemin = require("gulp-imagemin");
const mozjpeg = require("imagemin-mozjpeg");
const plumber = require("gulp-plumber");
const pngquant = require("imagemin-pngquant");
const sass = require("gulp-sass");

gulp.task("img", cb => {
  return gulp
    .src("./_assets/images/**/*")
    .pipe(
      imagemin([
        pngquant({ quality: [0.65, 0.8], speed: 1 }),
        mozjpeg({ quality: 85 }),
        imagemin.svgo({ plugins: [{ removeViewBox: false }] }),
        imagemin.gifsicle()
      ])
    )
    .pipe(gulp.dest("./assets/images"));
});

gulp.task("sass", cb => {
  return gulp
    .src("./_assets/styles/**/*.scss")
    .pipe(plumber())
    .pipe(
      sass.sync({
        precision: 10, // 計算時に小数点10桁まで出力
        outputStyle: "compressed" // nested/expanded/compact/compressed
      })
    )
    .pipe(autoprefixer())
    .pipe(gulp.dest("./assets/styles"));
});

gulp.task("watch", cb => {
  gulp.watch("./_assets/images/**/*", gulp.task("img"));
  gulp.watch("./_assets/styles/**/*.scss", gulp.task("sass"));
  cb();
});

gulp.task("default", gulp.series(gulp.parallel("img", "sass"), "watch"));

gulp.task("build", gulp.series(gulp.parallel("img", "sass")));
