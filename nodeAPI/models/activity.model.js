const mongoose = require("mongoose");
const Schema = mongoose.Schema;
const activitySchema = new Schema({
    idUser: {
        type: String,
        required: true
    },
    activityName: {
        type: String,
        maxLength: 30,
    },
    activityType: {
        type: String,
        required: true
    },
    activityTypeRecord: {
        type: String,
    },
    activityDate: {
        type: Date,
        required: true
    },
    activityDuration: {
        type: String,
    },
    activityDistance: {
        type: Number,
    },
    coordinates: [
        {
            lat: {
                type: Number,
                required: true
            },
            long: {
                type: Number,
                required: true
            }
        }
    ],
    steps: {
            type: Number,
        },
    description: {
        type: String,
    }

}, { collection: 'activity' });

module.exports.activity = mongoose.model('activity', activitySchema);
