const axios = require('axios');
const catchAsync = require('../utils/catchAsync');
const amadeus = require('../utils/amadeus');

exports.getHotels = catchAsync(async (req, res, next) => {
  const { latitude, longitude } = req.query;

  const hotels = await amadeus.shopping.hotelOffers.get({
    latitude: latitude,
    longitude: longitude,
  });
  console.log(hotels.data);
  res.status(200).json({ status: "success", data: { hotels: hotels.data } });
});

exports.getHotel = catchAsync(async (req, res, next) => {
  const { id } = req.query;

  const hotel = await amadeus.shopping.hotelOffersByHotel.get({
    hotelId: id
  });

  res.status(200).json({ status: "success", data: { hotel: hotel } });
});