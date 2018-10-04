import java.lang.*;
import java.util.Arrays;

public class Driver {
    public static int[] listOne = {91, 55, 88, 7, 18, 66, 72, 62, 77, 52, 96, 56, 42, 4,
                      68, 23, 13, 78, 22, 60, 94, 89, 98, 80, 74, 47, 81, 
                      17, 65, 41, 45, 30, 8, 12, 83, 3, 9, 19, 90, 64, 87, 
                      25, 46, 97, 6, 5, 61, 38, 40, 53, 43, 92, 16, 29, 28, 
                      39, 86, 67, 34, 31, 82, 84, 99, 48, 36, 70, 73, 24, 
                      75, 27, 85, 2, 14, 37, 95, 10, 58, 20, 35, 76, 71, 79, 
                      1, 44, 69, 21, 54, 11, 93, 51, 33, 59, 63, 57, 15, 26, 
                      49, 32, 50, 100};

    public static int[] sortedListOne = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
                           15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 
                           27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
                           39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
                           51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 
                           63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
                           75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 
                           87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 
                           99, 100};
    
    public static int[] smallListOne = {2,3,5,7,9,1,4,6,8,10};
    public static int[] smallSortedListOne = {1,2,3,4,5,6,7,8,9,10};
    
    public static int[] largeList = {21, 258, 380, 328, 923, 602, 645, 641, 121, 626, 627, 696, 699, 568, 993, 525, 422, 392, 981, 221, 663, 703, 357, 196, 566, 975, 806, 19, 336, 937, 893, 732, 410, 256, 376, 676, 105, 817, 983, 786, 961, 140, 306, 325, 389, 224, 819, 245, 93, 673, 242, 845, 689, 918, 719, 896, 625, 437, 480, 295, 530, 91, 882, 340, 319, 662, 631, 500, 110, 283, 83, 565, 954, 169, 188, 648, 607, 524, 986, 938, 772, 718, 700, 685, 7, 223, 728, 831, 508, 775, 600, 56, 276, 606, 244, 797, 374, 236, 532, 851, 239, 48, 876, 322, 814, 987, 758, 206, 361, 135, 66, 257, 826, 98, 905, 598, 610, 123, 234, 413, 960, 915, 897, 639, 237, 218, 682, 727, 856, 18, 855, 616, 783, 495, 670, 733, 844, 329, 619, 971, 434, 921, 172, 952, 618, 945, 517, 366, 935, 958, 136, 248, 399, 669, 547, 739, 407, 368, 664, 927, 269, 687, 720, 381, 38, 827, 751, 917, 152, 976, 168, 122, 929, 428, 934, 197, 552, 474, 443, 217, 485, 531, 550, 334, 591, 400, 112, 843, 43, 360, 46, 847, 199, 588, 182, 944, 301, 233, 840, 415, 638, 264, 131, 87, 507, 355, 174, 864, 133, 467, 426, 445, 291, 113, 567, 330, 61, 273, 714, 647, 378, 479, 534, 80, 989, 711, 931, 752, 834, 850, 356, 810, 484, 691, 955, 646, 702, 190, 637, 808, 24, 109, 995, 354, 537, 636, 456, 69, 782, 232, 249, 746, 654, 90, 521, 154, 514, 391, 76, 492, 858, 423, 991, 82, 633, 29, 522, 910, 554, 805, 425, 134, 388, 219, 794, 418, 708, 132, 504, 583, 175, 42, 717, 888, 471, 903, 660, 812, 251, 540, 556, 17, 186, 542, 45, 612, 27, 129, 920, 693, 13, 659, 272, 878, 924, 907, 569, 587, 596, 220, 243, 523, 977, 452, 683, 265, 515, 55, 830, 804, 811, 62, 951, 792, 231, 164, 871, 539, 226, 564, 58, 870, 667, 280, 762, 171, 349, 198, 94, 106, 953, 271, 416, 519, 880, 652, 743, 181, 1000, 803, 481, 449, 557, 526, 88, 789, 117, 527, 9, 966, 865, 643, 68, 351, 873, 406, 846, 936, 828, 721, 862, 268, 820, 686, 119, 461, 184, 111, 617, 998, 940, 885, 401, 516, 614, 179, 462, 585, 973, 994, 49, 859, 200, 560, 230, 713, 261, 535, 597, 761, 211, 97, 470, 371, 151, 649, 709, 439, 909, 765, 877, 161, 189, 609, 889, 107, 967, 666, 793, 980, 586, 668, 582, 680, 14, 64, 214, 501, 359, 8, 436, 302, 881, 615, 898, 432, 634, 756, 829, 370, 543, 429, 894, 816, 488, 40, 913, 163, 874, 692, 932, 777, 441, 455, 453, 629, 503, 868, 750, 857, 529, 755, 403, 818, 165, 832, 78, 520, 824, 884, 922, 697, 318, 362, 323, 872, 183, 141, 496, 570, 433, 939, 853, 906, 798, 205, 23, 284, 766, 331, 632, 475, 60, 509, 1, 379, 454, 778, 326, 478, 613, 394, 579, 590, 341, 528, 959, 788, 473, 116, 901, 770, 215, 81, 595, 37, 57, 483, 785, 674, 373, 823, 11, 604, 397, 736, 574, 605, 128, 157, 409, 178, 263, 759, 75, 912, 722, 352, 630, 701, 581, 308, 238, 167, 77, 278, 512, 311, 279, 875, 624, 246, 740, 544, 465, 848, 156, 44, 821, 290, 620, 180, 126, 580, 657, 207, 553, 837, 310, 734, 348, 933, 187, 33, 584, 809, 712, 644, 628, 421, 760, 70, 210, 31, 67, 158, 589, 468, 367, 317, 498, 860, 369, 289, 208, 594, 469, 22, 990, 240, 153, 947, 16, 611, 335, 867, 130, 506, 89, 715, 999, 252, 561, 85, 266, 836, 84, 678, 861, 282, 546, 118, 270, 623, 577, 926, 754, 710, 390, 642, 723, 125, 791, 30, 420, 886, 661, 333, 725, 296, 396, 166, 928, 71, 72, 866, 287, 447, 337, 737, 320, 99, 204, 285, 513, 964, 914, 95, 307, 150, 212, 563, 124, 573, 142, 450, 241, 767, 446, 353, 899, 984, 835, 729, 202, 735, 227, 576, 578, 176, 621, 103, 3, 203, 790, 312, 120, 559, 807, 39, 771, 300, 538, 472, 299, 784, 281, 555, 841, 457, 863, 741, 115, 377, 267, 494, 4, 114, 286, 229, 838, 773, 127, 891, 101, 799, 451, 979, 822, 675, 942, 395, 802, 854, 795, 74, 73, 79, 548, 431, 228, 170, 900, 985, 315, 704, 672, 763, 2, 656, 277, 688, 343, 477, 879, 890, 350, 292, 695, 344, 978, 293, 970, 635, 448, 748, 706, 622, 941, 690, 338, 193, 753, 297, 694, 36, 946, 707, 32, 731, 148, 459, 235, 491, 505, 160, 274, 363, 375, 650, 796, 393, 764, 51, 781, 769, 387, 177, 575, 414, 698, 592, 339, 813, 930, 259, 757, 41, 489, 53, 385, 15, 143, 47, 92, 6, 305, 96, 562, 974, 800, 825, 147, 499, 162, 314, 780, 405, 968, 490, 776, 833, 20, 681, 949, 774, 195, 35, 213, 262, 745, 482, 250, 424, 738, 603, 86, 943, 658, 969, 59, 466, 288, 332, 655, 904, 533, 34, 518, 149, 346, 464, 398, 65, 665, 63, 957, 10, 430, 902, 992, 651, 383, 442, 486, 956, 417, 887, 411, 852, 779, 545, 372, 768, 321, 640, 925, 108, 671, 502, 144, 54, 435, 892, 705, 146, 313, 324, 104, 869, 247, 982, 5, 260, 536, 275, 541, 192, 684, 963, 254, 593, 316, 209, 364, 510, 303, 185, 997, 309, 225, 849, 138, 493, 883, 294, 386, 460, 201, 408, 815, 742, 384, 255, 599, 744, 298, 194, 12, 440, 438, 222, 747, 26, 173, 608, 724, 404, 145, 911, 345, 358, 730, 327, 972, 950, 916, 601, 571, 402, 216, 895, 996, 412, 427, 463, 342, 908, 677, 50, 155, 25, 100, 191, 304, 919, 137, 487, 347, 444, 253, 102, 948, 497, 787, 726, 511, 52, 549, 28, 988, 139, 572, 382, 159, 365, 842, 801, 749, 458, 476, 419, 653, 962, 839, 679, 551, 965, 558, 716};

    public static int[] largeListSorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432, 433, 434, 435, 436, 437, 438, 439, 440, 441, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 484, 485, 486, 487, 488, 489, 490, 491, 492, 493, 494, 495, 496, 497, 498, 499, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511, 512, 513, 514, 515, 516, 517, 518, 519, 520, 521, 522, 523, 524, 525, 526, 527, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 638, 639, 640, 641, 642, 643, 644, 645, 646, 647, 648, 649, 650, 651, 652, 653, 654, 655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 669, 670, 671, 672, 673, 674, 675, 676, 677, 678, 679, 680, 681, 682, 683, 684, 685, 686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715, 716, 717, 718, 719, 720, 721, 722, 723, 724, 725, 726, 727, 728, 729, 730, 731, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747, 748, 749, 750, 751, 752, 753, 754, 755, 756, 757, 758, 759, 760, 761, 762, 763, 764, 765, 766, 767, 768, 769, 770, 771, 772, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783, 784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 852, 853, 854, 855, 856, 857, 858, 859, 860, 861, 862, 863, 864, 865, 866, 867, 868, 869, 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 911, 912, 913, 914, 915, 916, 917, 918, 919, 920, 921, 922, 923, 924, 925, 926, 927, 928, 929, 930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947, 948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, 999, 1000};

    public static void main(String[] args) {
      Sorts algSorts = new Sorts();
      int[] temp = smallListOne;

      algSorts.selectionSort(temp,10);
      System.out.println("Selection Sort 10 Passed: " + Arrays.equals(temp,smallSortedListOne));
    
      temp = listOne;
      algSorts.selectionSort(temp,100);
      System.out.println("Selection Sort 100 Passed: " + Arrays.equals(temp,sortedListOne));
    
      temp = largeList;
      algSorts.selectionSort(temp,1000);
      System.out.println("Selection Sort 1000 Passed: " + Arrays.equals(temp,largeListSorted));
    
      temp = smallListOne;
      algSorts.mergeSort(temp,10);
      System.out.println("\nMerge Sort 10 Passed: " + Arrays.equals(temp,smallSortedListOne));
    
      temp = listOne;
      algSorts.mergeSort(temp,100);
      System.out.println("Merge Sort 100 Passed: " + Arrays.equals(temp,sortedListOne));
    
      temp = largeList;
      algSorts.mergeSort(temp,1000);
      System.out.println("Merge Sort 1000 Passed: " + Arrays.equals(temp,largeListSorted));
      
      temp = smallListOne;
      algSorts.quickSort(temp,10);
      System.out.println("\nQuick Sort 10 Passed: " + Arrays.equals(temp,smallSortedListOne));
    
      temp = listOne;
      algSorts.quickSort(temp,100);
      System.out.println("Quick Sort 100 Passed: " + Arrays.equals(temp,sortedListOne));
    
      temp = largeList;
      algSorts.quickSort(temp,1000);
      System.out.println("Quick Sort 1000 Passed: " + Arrays.equals(temp,largeListSorted));
    }
}
